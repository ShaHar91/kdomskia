package io.kdomskia.compose.material3

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Density

@Composable
actual fun BasicTextField(
    state: TextFieldState,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    inputTransformation: InputTransformation?,
    textStyle: TextStyle,
    keyboardOptions: KeyboardOptions,
    onKeyboardAction: KeyboardActionHandler?,
    lineLimits: TextFieldLineLimits,
    onTextLayout: (Density.(getResult: () -> TextLayoutResult?) -> Unit)?,
    interactionSource: MutableInteractionSource?,
    cursorBrush: Brush,
    outputTransformation: OutputTransformation?,
    decorator: TextFieldDecorator?,
    scrollState: ScrollState
) {
}

@Composable
actual fun BasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    textStyle: TextStyle,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    maxLines: Int,
    minLines: Int,
    visualTransformation: VisualTransformation,
    onTextLayout: (TextLayoutResult) -> Unit,
    interactionSource: MutableInteractionSource?,
    cursorBrush: Brush,
    decorationBox: @Composable ((innerTextField: @Composable (() -> Unit)) -> Unit)
) {
}

@Composable
actual fun BasicTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    textStyle: TextStyle,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    maxLines: Int,
    minLines: Int,
    visualTransformation: VisualTransformation,
    onTextLayout: (TextLayoutResult) -> Unit,
    interactionSource: MutableInteractionSource?,
    cursorBrush: Brush,
    decorationBox: @Composable ((innerTextField: @Composable (() -> Unit)) -> Unit)
) {
}