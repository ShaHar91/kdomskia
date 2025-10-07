package io.kdomskia.compose.material3

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.TextFieldLabelPosition
import androidx.compose.material3.TextFieldLabelScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Density
import io.kdomskia.compose.foundation.layout.PaddingValues
import io.kdomskia.compose.ui.Modifier

@Composable
actual fun SecureTextField(
    state: TextFieldState,
    modifier: Modifier,
    enabled: Boolean,
    textStyle: TextStyle,
    labelPosition: TextFieldLabelPosition,
    label: @Composable (TextFieldLabelScope.() -> Unit)?,
    placeholder: @Composable (() -> Unit)?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    prefix: @Composable (() -> Unit)?,
    suffix: @Composable (() -> Unit)?,
    supportingText: @Composable (() -> Unit)?,
    isError: Boolean,
    inputTransformation: InputTransformation?,
    textObfuscationMode: TextObfuscationMode,
    textObfuscationCharacter: Char,
    keyboardOptions: KeyboardOptions,
    onKeyboardAction: KeyboardActionHandler?,
    onTextLayout: (Density.(getResult: () -> TextLayoutResult?) -> Unit)?,
    shape: Shape,
    colors: TextFieldColors,
    contentPadding: PaddingValues,
    interactionSource: MutableInteractionSource?
) {
}

@Composable
actual fun OutlinedSecureTextField(
    state: TextFieldState,
    modifier: Modifier,
    enabled: Boolean,
    textStyle: TextStyle,
    labelPosition: TextFieldLabelPosition,
    label: @Composable (TextFieldLabelScope.() -> Unit)?,
    placeholder: @Composable (() -> Unit)?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    prefix: @Composable (() -> Unit)?,
    suffix: @Composable (() -> Unit)?,
    supportingText: @Composable (() -> Unit)?,
    isError: Boolean,
    inputTransformation: InputTransformation?,
    textObfuscationMode: TextObfuscationMode,
    textObfuscationCharacter: Char,
    keyboardOptions: KeyboardOptions,
    onKeyboardAction: KeyboardActionHandler?,
    onTextLayout: (Density.(getResult: () -> TextLayoutResult?) -> Unit)?,
    shape: Shape,
    colors: TextFieldColors,
    contentPadding: PaddingValues,
    interactionSource: MutableInteractionSource?
) {
}
