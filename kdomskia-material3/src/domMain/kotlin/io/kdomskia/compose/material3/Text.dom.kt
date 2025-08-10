package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.thenIfNotNull
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.css.BoxOrient
import io.kdomskia.compose.css.WebkitInlineBox
import io.kdomskia.compose.css.boxOrient
import io.kdomskia.compose.css.lineClamp
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.graphics.dom
import io.kdomskia.compose.ui.text.font.dom
import io.kdomskia.compose.ui.text.style.dom
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text as DomText

@Composable
actual fun Text(
    text: String,
    modifier: Modifier,
    color: Color,
    fontSize: TextUnit,
    fontStyle: FontStyle?,
    fontWeight: FontWeight?,
    fontFamily: FontFamily?,
    letterSpacing: TextUnit,
    textAlign: TextAlign?,
    lineHeight: TextUnit,
    maxLines: Int,
    style: TextStyle
) {
    val textColor = color.takeOrElse { style.color.takeOrElse { LocalContentColor.current } }

    BasicText(
        text = text,
        modifier = modifier,
        style = style.merge(
            color = textColor,
            fontSize = fontSize,
            fontWeight = fontWeight,
            textAlign = textAlign ?: TextAlign.Unspecified,
            lineHeight = lineHeight,
            fontFamily = fontFamily,
            fontStyle = fontStyle,
            letterSpacing = letterSpacing,
        ),
        maxLines = maxLines
    )
}

@Composable
private fun BasicText(
    text: String,
    modifier: Modifier,
    style: TextStyle,
    maxLines: Int
) {
    Span(
        attrs = modifier
            .dom
            .thenIfNotNull(style.fontFamily?.dom(style.fontWeight)) {
                DomModifier.fontFamily(it)
            }
            .thenIfNotNull(style.fontStyle?.dom) {
                DomModifier.fontStyle(it)
            }
            .thenIfNotNull(style.fontSize.dom) {
                DomModifier.fontSize(it)
            }
            .thenIfNotNull(style.lineHeight.dom) {
                DomModifier.lineHeight(it)
            }
            .thenIfNotNull(style.letterSpacing.dom) {
                DomModifier.letterSpacing(it)
            }
            .thenIfNotNull(style.fontWeight?.dom) {
                DomModifier.fontWeight(it)
            }
            .thenIf(style.color.isSpecified) {
                DomModifier.color(style.color.dom)
            }
            .thenIf(style.background.isSpecified) {
                DomModifier.background(style.background.dom)
            }
            .textAlign(style.textAlign.dom)
            .display(DisplayStyle.WebkitInlineBox)
            .lineClamp(maxLines)
            .boxOrient(BoxOrient.Vertical)
            .overflow(Overflow.Hidden)
            .toAttrs()
    ) {
        DomText(
            value = text
        )
    }
}