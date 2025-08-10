package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import io.kdomskia.compose.internal.CheckKdomskiaInitialization
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.LocalTextStyle as SkiaLocalTextStyle

@Composable
expect fun Text(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = LocalTextStyle.current,
)

object LocalTextStyle {

    val current: TextStyle
        @ReadOnlyComposable
        @Composable
        get() = SkiaLocalTextStyle.current

}

@Composable
fun ProvideTextStyle(
    style: TextStyle,
    content: @Composable () -> Unit
) {
    CheckKdomskiaInitialization()
    CompositionLocalProvider(
        SkiaLocalTextStyle provides style,
        content = content
    )
}