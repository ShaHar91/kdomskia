package io.kdomskia.compose.material3

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import io.kdomskia.compose.ui.Modifier

internal typealias SkiaTextFieldColors = androidx.compose.material3.TextFieldColors
internal typealias SkiaTextFieldDefaults = androidx.compose.material3.TextFieldDefaults

@Composable
expect fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    shape: Shape = TextFieldDefaults.shape,
    colors: TextFieldColors = TextFieldDefaults.colors()
)

internal val SkiaTextFieldColors.kdomskia: TextFieldColors
    get() = TextFieldColors(
        focusedTextColor = focusedTextColor,
        unfocusedTextColor = unfocusedTextColor,
        disabledTextColor = disabledTextColor,
        errorTextColor = errorTextColor,
        focusedContainerColor = focusedContainerColor,
        unfocusedContainerColor = unfocusedContainerColor,
        disabledContainerColor = disabledContainerColor,
        errorContainerColor = errorContainerColor,
        cursorColor = cursorColor,
        errorCursorColor = errorCursorColor,
        textSelectionColors = textSelectionColors,
        focusedIndicatorColor = focusedIndicatorColor,
        unfocusedIndicatorColor = unfocusedIndicatorColor,
        disabledIndicatorColor = disabledIndicatorColor,
        errorIndicatorColor = errorIndicatorColor,
        focusedLeadingIconColor = focusedLeadingIconColor,
        unfocusedLeadingIconColor = unfocusedLeadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,
        errorLeadingIconColor = errorLeadingIconColor,
        focusedTrailingIconColor = focusedTrailingIconColor,
        unfocusedTrailingIconColor = unfocusedTrailingIconColor,
        disabledTrailingIconColor = disabledTrailingIconColor,
        errorTrailingIconColor = errorTrailingIconColor,
        focusedLabelColor = focusedLabelColor,
        unfocusedLabelColor = unfocusedLabelColor,
        disabledLabelColor = disabledLabelColor,
        errorLabelColor = errorLabelColor,
        focusedPlaceholderColor = focusedPlaceholderColor,
        unfocusedPlaceholderColor = unfocusedPlaceholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        errorPlaceholderColor = errorPlaceholderColor,
        focusedSupportingTextColor = focusedSupportingTextColor,
        unfocusedSupportingTextColor = unfocusedSupportingTextColor,
        disabledSupportingTextColor = disabledSupportingTextColor,
        errorSupportingTextColor = errorSupportingTextColor,
        focusedPrefixColor = focusedPrefixColor,
        unfocusedPrefixColor = unfocusedPrefixColor,
        disabledPrefixColor = disabledPrefixColor,
        errorPrefixColor = errorPrefixColor,
        focusedSuffixColor = focusedSuffixColor,
        unfocusedSuffixColor = unfocusedSuffixColor,
        disabledSuffixColor = disabledSuffixColor,
        errorSuffixColor = errorSuffixColor

    )

@Immutable
class TextFieldColors(
    focusedTextColor: Color,
    unfocusedTextColor: Color,
    disabledTextColor: Color,
    errorTextColor: Color,
    focusedContainerColor: Color,
    unfocusedContainerColor: Color,
    disabledContainerColor: Color,
    errorContainerColor: Color,
    cursorColor: Color,
    errorCursorColor: Color,
    textSelectionColors: TextSelectionColors,
    focusedIndicatorColor: Color,
    unfocusedIndicatorColor: Color,
    disabledIndicatorColor: Color,
    errorIndicatorColor: Color,
    focusedLeadingIconColor: Color,
    unfocusedLeadingIconColor: Color,
    disabledLeadingIconColor: Color,
    errorLeadingIconColor: Color,
    focusedTrailingIconColor: Color,
    unfocusedTrailingIconColor: Color,
    disabledTrailingIconColor: Color,
    errorTrailingIconColor: Color,
    focusedLabelColor: Color,
    unfocusedLabelColor: Color,
    disabledLabelColor: Color,
    errorLabelColor: Color,
    focusedPlaceholderColor: Color,
    unfocusedPlaceholderColor: Color,
    disabledPlaceholderColor: Color,
    errorPlaceholderColor: Color,
    focusedSupportingTextColor: Color,
    unfocusedSupportingTextColor: Color,
    disabledSupportingTextColor: Color,
    errorSupportingTextColor: Color,
    focusedPrefixColor: Color,
    unfocusedPrefixColor: Color,
    disabledPrefixColor: Color,
    errorPrefixColor: Color,
    focusedSuffixColor: Color,
    unfocusedSuffixColor: Color,
    disabledSuffixColor: Color,
    errorSuffixColor: Color
) {

    internal val _skia = SkiaTextFieldColors(
        focusedTextColor = focusedTextColor,
        unfocusedTextColor = unfocusedTextColor,
        disabledTextColor = disabledTextColor,
        errorTextColor = errorTextColor,
        focusedContainerColor = focusedContainerColor,
        unfocusedContainerColor = unfocusedContainerColor,
        disabledContainerColor = disabledContainerColor,
        errorContainerColor = errorContainerColor,
        cursorColor = cursorColor,
        errorCursorColor = errorCursorColor,
        textSelectionColors = textSelectionColors,
        focusedIndicatorColor = focusedIndicatorColor,
        unfocusedIndicatorColor = unfocusedIndicatorColor,
        disabledIndicatorColor = disabledIndicatorColor,
        errorIndicatorColor = errorIndicatorColor,
        focusedLeadingIconColor = focusedLeadingIconColor,
        unfocusedLeadingIconColor = unfocusedLeadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,
        errorLeadingIconColor = errorLeadingIconColor,
        focusedTrailingIconColor = focusedTrailingIconColor,
        unfocusedTrailingIconColor = unfocusedTrailingIconColor,
        disabledTrailingIconColor = disabledTrailingIconColor,
        errorTrailingIconColor = errorTrailingIconColor,
        focusedLabelColor = focusedLabelColor,
        unfocusedLabelColor = unfocusedLabelColor,
        disabledLabelColor = disabledLabelColor,
        errorLabelColor = errorLabelColor,
        focusedPlaceholderColor = focusedPlaceholderColor,
        unfocusedPlaceholderColor = unfocusedPlaceholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        errorPlaceholderColor = errorPlaceholderColor,
        focusedSupportingTextColor = focusedSupportingTextColor,
        unfocusedSupportingTextColor = unfocusedSupportingTextColor,
        disabledSupportingTextColor = disabledSupportingTextColor,
        errorSupportingTextColor = errorSupportingTextColor,
        focusedPrefixColor = focusedPrefixColor,
        unfocusedPrefixColor = unfocusedPrefixColor,
        disabledPrefixColor = disabledPrefixColor,
        errorPrefixColor = errorPrefixColor,
        focusedSuffixColor = focusedSuffixColor,
        unfocusedSuffixColor = unfocusedSuffixColor,
        disabledSuffixColor = disabledSuffixColor,
        errorSuffixColor = errorSuffixColor
    )

    fun copy(
        focusedTextColor: Color = this.focusedTextColor,
        unfocusedTextColor: Color = this.unfocusedTextColor,
        disabledTextColor: Color = this.disabledTextColor,
        errorTextColor: Color = this.errorTextColor,
        focusedContainerColor: Color = this.focusedContainerColor,
        unfocusedContainerColor: Color = this.unfocusedContainerColor,
        disabledContainerColor: Color = this.disabledContainerColor,
        errorContainerColor: Color = this.errorContainerColor,
        cursorColor: Color = this.cursorColor,
        errorCursorColor: Color = this.errorCursorColor,
        textSelectionColors: TextSelectionColors? = this.textSelectionColors,
        focusedIndicatorColor: Color = this.focusedIndicatorColor,
        unfocusedIndicatorColor: Color = this.unfocusedIndicatorColor,
        disabledIndicatorColor: Color = this.disabledIndicatorColor,
        errorIndicatorColor: Color = this.errorIndicatorColor,
        focusedLeadingIconColor: Color = this.focusedLeadingIconColor,
        unfocusedLeadingIconColor: Color = this.unfocusedLeadingIconColor,
        disabledLeadingIconColor: Color = this.disabledLeadingIconColor,
        errorLeadingIconColor: Color = this.errorLeadingIconColor,
        focusedTrailingIconColor: Color = this.focusedTrailingIconColor,
        unfocusedTrailingIconColor: Color = this.unfocusedTrailingIconColor,
        disabledTrailingIconColor: Color = this.disabledTrailingIconColor,
        errorTrailingIconColor: Color = this.errorTrailingIconColor,
        focusedLabelColor: Color = this.focusedLabelColor,
        unfocusedLabelColor: Color = this.unfocusedLabelColor,
        disabledLabelColor: Color = this.disabledLabelColor,
        errorLabelColor: Color = this.errorLabelColor,
        focusedPlaceholderColor: Color = this.focusedPlaceholderColor,
        unfocusedPlaceholderColor: Color = this.unfocusedPlaceholderColor,
        disabledPlaceholderColor: Color = this.disabledPlaceholderColor,
        errorPlaceholderColor: Color = this.errorPlaceholderColor,
        focusedSupportingTextColor: Color = this.focusedSupportingTextColor,
        unfocusedSupportingTextColor: Color = this.unfocusedSupportingTextColor,
        disabledSupportingTextColor: Color = this.disabledSupportingTextColor,
        errorSupportingTextColor: Color = this.errorSupportingTextColor,
        focusedPrefixColor: Color = this.focusedPrefixColor,
        unfocusedPrefixColor: Color = this.unfocusedPrefixColor,
        disabledPrefixColor: Color = this.disabledPrefixColor,
        errorPrefixColor: Color = this.errorPrefixColor,
        focusedSuffixColor: Color = this.focusedSuffixColor,
        unfocusedSuffixColor: Color = this.unfocusedSuffixColor,
        disabledSuffixColor: Color = this.disabledSuffixColor,
        errorSuffixColor: Color = this.errorSuffixColor
    ): TextFieldColors = TextFieldColors(
        focusedTextColor = focusedTextColor,
        unfocusedTextColor = unfocusedTextColor,
        disabledTextColor = disabledTextColor,
        errorTextColor = errorTextColor,
        focusedContainerColor = focusedContainerColor,
        unfocusedContainerColor = unfocusedContainerColor,
        disabledContainerColor = disabledContainerColor,
        errorContainerColor = errorContainerColor,
        cursorColor = cursorColor,
        errorCursorColor = errorCursorColor,
        textSelectionColors = textSelectionColors.takeOrElse { this.textSelectionColors },
        focusedIndicatorColor = focusedIndicatorColor,
        unfocusedIndicatorColor = unfocusedIndicatorColor,
        disabledIndicatorColor = disabledIndicatorColor,
        errorIndicatorColor = errorIndicatorColor,
        focusedLeadingIconColor = focusedLeadingIconColor,
        unfocusedLeadingIconColor = unfocusedLeadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,
        errorLeadingIconColor = errorLeadingIconColor,
        focusedTrailingIconColor = focusedTrailingIconColor,
        unfocusedTrailingIconColor = unfocusedTrailingIconColor,
        disabledTrailingIconColor = disabledTrailingIconColor,
        errorTrailingIconColor = errorTrailingIconColor,
        focusedLabelColor = focusedLabelColor,
        unfocusedLabelColor = unfocusedLabelColor,
        disabledLabelColor = disabledLabelColor,
        errorLabelColor = errorLabelColor,
        focusedPlaceholderColor = focusedPlaceholderColor,
        unfocusedPlaceholderColor = unfocusedPlaceholderColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        errorPlaceholderColor = errorPlaceholderColor,
        focusedSupportingTextColor = focusedSupportingTextColor,
        unfocusedSupportingTextColor = unfocusedSupportingTextColor,
        disabledSupportingTextColor = disabledSupportingTextColor,
        errorSupportingTextColor = errorSupportingTextColor,
        focusedPrefixColor = focusedPrefixColor,
        unfocusedPrefixColor = unfocusedPrefixColor,
        disabledPrefixColor = disabledPrefixColor,
        errorPrefixColor = errorPrefixColor,
        focusedSuffixColor = focusedSuffixColor,
        unfocusedSuffixColor = unfocusedSuffixColor,
        disabledSuffixColor = disabledSuffixColor,
        errorSuffixColor = errorSuffixColor
    )

    internal fun TextSelectionColors?.takeOrElse(
        block: () -> TextSelectionColors
    ): TextSelectionColors = this ?: block()

    val focusedTextColor: Color
        get() = _skia.focusedTextColor
    val unfocusedTextColor: Color
        get() = _skia.unfocusedTextColor
    val disabledTextColor: Color
        get() = _skia.disabledTextColor
    val errorTextColor: Color
        get() = _skia.errorTextColor
    val focusedContainerColor: Color
        get() = _skia.focusedContainerColor
    val unfocusedContainerColor: Color
        get() = _skia.unfocusedContainerColor
    val disabledContainerColor: Color
        get() = _skia.disabledContainerColor
    val errorContainerColor: Color
        get() = _skia.errorContainerColor
    val cursorColor: Color
        get() = _skia.cursorColor
    val errorCursorColor: Color
        get() = _skia.errorCursorColor
    val textSelectionColors: TextSelectionColors
        get() = _skia.textSelectionColors
    val focusedIndicatorColor: Color
        get() = _skia.focusedIndicatorColor
    val unfocusedIndicatorColor: Color
        get() = _skia.unfocusedIndicatorColor
    val disabledIndicatorColor: Color
        get() = _skia.disabledIndicatorColor
    val errorIndicatorColor: Color
        get() = _skia.errorIndicatorColor
    val focusedLeadingIconColor: Color
        get() = _skia.focusedLeadingIconColor
    val unfocusedLeadingIconColor: Color
        get() = _skia.unfocusedLeadingIconColor
    val disabledLeadingIconColor: Color
        get() = _skia.disabledLeadingIconColor
    val errorLeadingIconColor: Color
        get() = _skia.errorLeadingIconColor
    val focusedTrailingIconColor: Color
        get() = _skia.focusedTrailingIconColor
    val unfocusedTrailingIconColor: Color
        get() = _skia.unfocusedTrailingIconColor
    val disabledTrailingIconColor: Color
        get() = _skia.disabledTrailingIconColor
    val errorTrailingIconColor: Color
        get() = _skia.errorTrailingIconColor
    val focusedLabelColor: Color
        get() = _skia.focusedLabelColor
    val unfocusedLabelColor: Color
        get() = _skia.unfocusedLabelColor
    val disabledLabelColor: Color
        get() = _skia.disabledLabelColor
    val errorLabelColor: Color
        get() = _skia.errorLabelColor
    val focusedPlaceholderColor: Color
        get() = _skia.focusedPlaceholderColor
    val unfocusedPlaceholderColor: Color
        get() = _skia.unfocusedPlaceholderColor
    val disabledPlaceholderColor: Color
        get() = _skia.disabledPlaceholderColor
    val errorPlaceholderColor: Color
        get() = _skia.errorPlaceholderColor
    val focusedSupportingTextColor: Color
        get() = _skia.focusedSupportingTextColor
    val unfocusedSupportingTextColor: Color
        get() = _skia.unfocusedSupportingTextColor
    val disabledSupportingTextColor: Color
        get() = _skia.disabledSupportingTextColor
    val errorSupportingTextColor: Color
        get() = _skia.errorSupportingTextColor
    val focusedPrefixColor: Color
        get() = _skia.focusedPrefixColor
    val unfocusedPrefixColor: Color
        get() = _skia.unfocusedPrefixColor
    val disabledPrefixColor: Color
        get() = _skia.disabledPrefixColor
    val errorPrefixColor: Color
        get() = _skia.errorPrefixColor
    val focusedSuffixColor: Color
        get() = _skia.focusedSuffixColor
    val unfocusedSuffixColor: Color
        get() = _skia.unfocusedSuffixColor
    val disabledSuffixColor: Color
        get() = _skia.disabledSuffixColor
    val errorSuffixColor: Color
        get() = _skia.errorSuffixColor


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is ButtonColors) return false

        return _skia == other._skia
    }

    override fun hashCode() = _skia.hashCode()
}

object TextFieldDefaults {
    @Composable
    fun colors() = SkiaTextFieldDefaults.colors().kdomskia

    val shape: Shape
        @Composable
        get() = SkiaTextFieldDefaults.shape
}