package io.kdomskia.compose.material3.beer

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import com.varabyte.kobweb.compose.css.disabled
import com.varabyte.kobweb.compose.ui.modifiers.onFocus
import com.varabyte.kobweb.compose.ui.modifiers.onFocusOut
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.spellCheck
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.css.TypeSafeClass
import io.kdomskia.compose.extension.addIf
import io.kdomskia.compose.extension.parentHtmlElement
import io.kdomskia.compose.foundation.layout.Box
import io.kdomskia.compose.foundation.layout.fillMaxWidth
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.material3.TextFieldColors
import io.kdomskia.compose.material3.css.beer.BeerVariable
import io.kdomskia.compose.ui.Modifier
import kotlinx.css.px
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.readOnly
import org.jetbrains.compose.web.css.StylePropertyValue
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.TextArea
import kotlin.math.max

@Composable
fun BeerTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    textStyle: TextStyle,
    label: @Composable (() -> Unit)?,
    placeholder: String?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    prefix: @Composable (() -> Unit)?,
    suffix: @Composable (() -> Unit)?,
    supportingText: @Composable (() -> Unit)?,
    isError: Boolean,
    visualTransformation: VisualTransformation,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    maxLines: Int,
    minLines: Int,
    shape: Shape,
    colors: TextFieldColors
) {
    var focused by remember { mutableStateOf(false) }
    var height by remember { mutableStateOf(0) }

    Div(
        attrs = modifier.unwrap {
            val classes = listOf(
                TypeSafeClass("field"),
                TypeSafeClass("label"),
                TypeSafeClass("fill")
            ).addIf(isError, TypeSafeClass("invalid"))
                .addIf(!singleLine, TypeSafeClass("textarea"))
                .addIf(!singleLine, TypeSafeClass("min"))

            typeSafeClasses(classes)
        }
            .dom
            .thenIf(!singleLine && value.isNotBlank()) {
                Modifier.dom.setVariable(BeerVariable.size, StylePropertyValue(height.px.value))
            }
            .toAttrs()
    ) {
        val baseModifier = Modifier
            .fillMaxWidth()
            .dom
            .spellCheck(true)
            .onFocus {
                focused = true
            }
            .onFocusOut {
                focused = false
            }

        if (singleLine) {
            Input(
                type = InputType.Text,
                attrs = baseModifier
                    .toAttrs {
                        value(value)
                        placeholder(if (placeholder != null && focused) placeholder else " ")
                        if (!enabled) disabled()
                        if (readOnly) readOnly()
                        onInput { evt -> onValueChange(InputType.Text.inputValue(evt.nativeEvent)) }
                    }
            )
        } else {
            TextArea(
                value = value,
                attrs = baseModifier
                    .toAttrs {
                        placeholder(if (placeholder != null && focused) placeholder else " ")
                        if (!enabled) disabled()
                        if (readOnly) readOnly()
                        onInput {
                            val element = it.target
                            val some = max(element.scrollHeight, element.parentHtmlElement?.offsetHeight ?: 0)
                            height = some

                            onValueChange(it.value)
                        }
                    }
            )
        }

        label?.let {
            Label {
                it()
            }
        }

        if (supportingText != null) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .unwrap {
                        typeSafeClasses(TypeSafeClass(if (isError) "error" else "helper"))
                    }
            ) {
                supportingText()
            }
        }
    }
}