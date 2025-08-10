package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.compositionLocalOf
import io.kdomskia.compose.ui.graphics.dom
import kotlinx.browser.document
import org.w3c.dom.HTMLElement

@Composable
internal actual fun PlatformMaterialTheme() {
    val ref = LocalMaterialThemeReferenceCount.current
    val colorScheme = MaterialTheme.colorScheme
    DisposableEffect(Unit) {
        if (ref.count == 0) {
            val color = colorScheme.background.dom.toString()
            (document.documentElement as? HTMLElement)?.style?.background = color
            document.body?.style?.background = color
            setThemeColor(color)
        }
        ref.count++
        onDispose {
            ref.count--
        }
    }
}

private fun setThemeColor(color: String) {
    var metaTag = document.querySelector("meta[name='theme-color']")
    if (metaTag == null) {
        metaTag = document.createElement("meta")
        metaTag.setAttribute("name", "theme-color")
        document.head?.appendChild(metaTag)
    }
    metaTag.setAttribute("content", color)
}

private val LocalMaterialThemeReferenceCount = compositionLocalOf {
    MaterialThemeReferenceCount()
}

private class MaterialThemeReferenceCount(
    var count: Int = 0
)