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
import io.kdomskia.compose.foundation.layout.skia
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.OutlinedSecureTextField as SkiaOutlinedSecureTextField
import androidx.compose.material3.SecureTextField as SkiaSecureTextField

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
    SkiaSecureTextField(
        state = state,
        modifier = modifier.skia,
        enabled = enabled,
        textStyle = textStyle,
        labelPosition = labelPosition,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        prefix = prefix,
        suffix = suffix,
        supportingText = supportingText,
        isError = isError,
        inputTransformation = inputTransformation,
        textObfuscationMode = textObfuscationMode,
        textObfuscationCharacter = textObfuscationCharacter,
        keyboardOptions = keyboardOptions,
        onKeyboardAction = onKeyboardAction,
        onTextLayout = onTextLayout,
        shape = shape,
        colors = colors.skia,
        contentPadding = contentPadding.skia,
        interactionSource = interactionSource
    )
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
    SkiaOutlinedSecureTextField(
        state = state,
        modifier = modifier.skia,
        enabled = enabled,
        textStyle = textStyle,
        labelPosition = labelPosition,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        prefix = prefix,
        suffix = suffix,
        supportingText = supportingText,
        isError = isError,
        inputTransformation = inputTransformation,
        textObfuscationMode = textObfuscationMode,
        textObfuscationCharacter = textObfuscationCharacter,
        keyboardOptions = keyboardOptions,
        onKeyboardAction = onKeyboardAction,
        onTextLayout = onTextLayout,
        shape = shape,
        colors = colors.skia,
        contentPadding = contentPadding.skia,
        interactionSource = interactionSource
    )
}
