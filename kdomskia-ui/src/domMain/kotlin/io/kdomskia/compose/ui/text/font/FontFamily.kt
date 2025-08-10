package io.kdomskia.compose.ui.text.font

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontListFontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.GenericFontFamily
import androidx.compose.ui.text.font.LoadedFontFamily
import androidx.compose.ui.text.platform.LoadedFont
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.fontStyle
import com.varabyte.kobweb.compose.css.fontWeight
import com.varabyte.kobweb.compose.css.functions.url
import io.kdomskia.compose.css.src
import io.kdomskia.compose.css.styleSheet
import kotlin.math.abs
import kotlinx.browser.document
import kotlinx.dom.createElement
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.utils.serializeRules

@Stable
fun FontFamily.dom(
    fontWeight: FontWeight?
): String? {
    val loadedFonts = loadedFonts
    if (loadedFonts.isEmpty())
        return null

    val targetWeight = fontWeight?.weight
    val font = if (targetWeight == null) {
        loadedFonts.first()
    } else {
        val sameWeightFont = loadedFonts.firstOrNull {
            it.weight.weight == targetWeight
        }

        if (sameWeightFont != null) {
            sameWeightFont
        } else {
            val sorted = loadedFonts.sortedBy { it.weight.weight }
            var closestFont = sorted.first()

            sorted.forEach {
                val closestWeight = closestFont.weight.weight
                if (abs(it.weight.weight - targetWeight) <= abs(closestWeight - targetWeight)) {
                    closestFont = it
                }
            }

            closestFont
        }
    }

    font.addRuleIfNeeded()

    return font.domFamily
}

private val FontFamily?.loadedFonts: List<LoadedFont>
    get() = when (val family = this) {
        is FontListFontFamily -> {
            family.fonts.mapNotNull { font ->
                when (font) {
                    is LoadedFont -> {
                        val identities = font.identity.split(":")
                        if (identities.any { it.contains("/font/") }) {
                            font
                        } else {
                            null
                        }
                    }

                    else -> null
                }

            }
        }

        is LoadedFontFamily -> {
            emptyList()
        }

        is GenericFontFamily -> {
            emptyList()
        }

        else -> {
            emptyList()
        }
    }

private var addedFontFamilyIds = mutableListOf<String>()

private fun LoadedFont.addRuleIfNeeded() {
    val family = domFamily

    if (family in addedFontFamilyIds)
        return

    val url = identity.split(":").firstOrNull().orEmpty()

    val fontFaceRule = styleSheet {
        "@font-face" {
            fontFamily(family)
            src(url(url))
            fontWeight(weight.dom)
            fontStyle(style.dom ?: FontStyle.Normal)
        }
    }.serializeRules().joinToString("\n")

    document.head?.insertAdjacentElement(
        "beforeend",
        document.createElement("style") {
            innerHTML = fontFaceRule
        }
    )

    addedFontFamilyIds.add(family)
}

private val LoadedFont.domFamily: String
    get() = identity
        .split(":").firstOrNull().orEmpty()
        .split(".").let { it.getOrNull(it.lastIndex - 1).orEmpty() }
        .split("/").lastOrNull().orEmpty() + "_" + weight.weight + "_" + style