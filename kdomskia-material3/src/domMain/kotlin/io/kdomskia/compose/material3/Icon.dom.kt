package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.ui.modifiers.ariaLabel
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.foundation.background
import io.kdomskia.compose.foundation.layout.size
import io.kdomskia.compose.material3.tokens.IconButtonTokens
import io.kdomskia.compose.ui.resource.ImageResource
import io.kdomskia.compose.ui.Modifier
import org.jetbrains.compose.web.dom.Div

@Composable
actual fun Icon(
    img: ImageResource,
    contentDescription: String?,
    modifier: Modifier,
    tint: Color
) {
    val uri = img.uri
    Div(
        attrs = Modifier
            .size(IconButtonTokens.IconSize)
            .then(modifier)
            .background(tint)
            .dom
            .ariaLabel(contentDescription.orEmpty())
            .styleModifier {
                property("mask", url(uri))
                property("mask-size", "contain")
                property("mask-repeat", "no-repeat")
                property("mask-position", "center")
                property("-webkit-mask", url(uri))
                property("-webkit-mask-size", "contain")
                property("-webkit-mask-repeat", "no-repeat")
                property("-webkit-mask-position", "center")
            }
            .toAttrs()
    )
}