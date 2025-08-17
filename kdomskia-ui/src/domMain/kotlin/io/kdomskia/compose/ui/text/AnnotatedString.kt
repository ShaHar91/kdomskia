package io.kdomskia.compose.ui.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import io.kdomskia.compose.ui.graphics.dom
import io.kdomskia.compose.ui.text.font.dom
import io.kdomskia.compose.ui.text.style.dom
import io.kdomskia.compose.ui.unit.dom

fun AnnotatedString.toHtml(): String {
    if (paragraphStyles.isEmpty())
        return buildSpansHtml(this, 0, text.length)

    val sb = StringBuilder()
    var lastParagraphEnd = 0

    paragraphStyles.forEach { paragraph ->
        if (paragraph.start > lastParagraphEnd)
            sb.append(escapeHtml(text.substring(lastParagraphEnd, paragraph.start)))

        val css = paragraphStyleToCss(paragraph.item)
        val content = buildSpansHtml(this, paragraph.start, paragraph.end)
        sb.append("<p style=\"$css\">$content</p>")

        lastParagraphEnd = paragraph.end
    }

    if (lastParagraphEnd < text.length) {
        sb.append(buildSpansHtml(this, lastParagraphEnd, text.length))
    }

    return sb.toString()
}

private fun buildSpansHtml(str: AnnotatedString, start: Int, end: Int): String {
    val sb = StringBuilder()
    var lastIndex = start

    str.spanStyles.forEach { span ->
        if (span.start in start until end || span.end in (start + 1)..end) {
            val safeStart = maxOf(span.start, start)
            val safeEnd = minOf(span.end, end)

            if (safeStart > lastIndex) {
                sb.append(escapeHtml(str.text.substring(lastIndex, safeStart)))
            }

            val spanText = escapeHtml(str.text.substring(safeStart, safeEnd))
            val css = spanStyleToCss(span.item)

            val url = str.getStringAnnotations("URL", safeStart, safeEnd).firstOrNull()?.item
            val openTag = if (url != null) "<a href=\"$url\"><span style=\"$css\">" else "<span style=\"$css\">"
            val closeTag = if (url != null) "</span></a>" else "</span>"

            sb.append(openTag).append(spanText).append(closeTag)

            lastIndex = safeEnd
        }
    }

    if (lastIndex < end) {
        sb.append(escapeHtml(str.text.substring(lastIndex, end)))
    }

    return sb.toString()
}

private fun spanStyleToCss(style: SpanStyle): String {
    val css = mutableListOf<String>()

    css.add("font-size:${style.fontSize.dom}")
    css.add("letter-spacing:${style.letterSpacing.dom}")

    style.background.takeIf { it != Color.Unspecified }?.let {
        css.add("background:${it.dom}")
    }
    style.color.takeIf { it != Color.Unspecified }?.let {
        css.add("color:${it.dom}")
    }
    style.fontFamily?.dom(style.fontWeight)?.let {
        css.add("font-family:${it}")
    }
    style.fontWeight?.let {
        css.add("font-weight:${it.dom}")
    }
    style.fontStyle?.let {
        css.add("font-style:${it.dom}")
    }
    style.textDecoration?.let {
        css.add("text-decoration:${it.dom}")
    }

    return css.joinToString(";")
}

private fun paragraphStyleToCss(style: ParagraphStyle): String {
    val css = mutableListOf<String>()

    css.add("text-align:${style.textAlign.dom}")
    css.add("line-height:${style.lineHeight.dom}")

    return css.joinToString(";")
}

private fun escapeHtml(text: String): String =
    text.replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\n", "<br>")