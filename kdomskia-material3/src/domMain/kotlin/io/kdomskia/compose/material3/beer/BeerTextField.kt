package io.kdomskia.compose.material3.beer

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import com.varabyte.kobweb.compose.css.disabled
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.onFocus
import com.varabyte.kobweb.compose.ui.modifiers.onFocusOut
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.spellCheck
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.thenIfNotNull
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.css.BeerStyleSheet
import io.kdomskia.compose.css.TypeSafeClass
import io.kdomskia.compose.extension.addIf
import io.kdomskia.compose.extension.parentHtmlElement
import io.kdomskia.compose.foundation.layout.Box
import io.kdomskia.compose.foundation.layout.fillMaxWidth
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.material3.TextFieldColors
import io.kdomskia.compose.material3.css.beer.BeerVariable
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.graphics.dom
import io.kdomskia.compose.ui.text.font.dom
import io.kdomskia.compose.ui.text.style.dom
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.readOnly
import org.jetbrains.compose.web.css.StylePropertyValue
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.plus
import org.jetbrains.compose.web.css.px
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
    val minLinesPx = textStyle.lineHeight.times(minLines).dom
    val maxLinesPx = textStyle.lineHeight.times(maxLines).dom

    var focused by remember { mutableStateOf(false) }
    var height by remember { mutableStateOf(minLinesPx?.plus(2.cssRem) ?: 0.px) }

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
            .thenIf(!singleLine) {
                Modifier.dom.setVariable(BeerVariable.size, StylePropertyValue(height.toString()))
            }
            .styleModifier {
                property("max-block-size", maxLinesPx?.plus(1.cssRem) ?: 0.cssRem)
                property("min-block-size", minLinesPx?.plus(1.cssRem) ?: Int.MAX_VALUE.cssRem)
            }
            .toAttrs()
    ) {
        val baseModifier = Modifier
            .fillMaxWidth()
            .dom
            .thenIfNotNull(textStyle.fontFamily?.dom(textStyle.fontWeight)) {
                DomModifier.fontFamily(it)
            }
            .thenIfNotNull(textStyle.fontStyle?.dom) {
                DomModifier.fontStyle(it)
            }
            .thenIfNotNull(textStyle.fontSize.dom) {
                DomModifier.fontSize(it)
            }
            .thenIfNotNull(textStyle.lineHeight.dom) {
                DomModifier.lineHeight(it)
            }
            .thenIfNotNull(textStyle.letterSpacing.dom) {
                DomModifier.letterSpacing(it)
            }
            .thenIfNotNull(textStyle.textDecoration?.dom) {
                DomModifier.textDecorationLine(it)
            }
            .thenIfNotNull(textStyle.fontWeight?.dom) {
                DomModifier.fontWeight(it)
            }
            .thenIf(textStyle.color.isSpecified) {
                DomModifier.color(textStyle.color.dom)
            }
            .thenIf(textStyle.background.isSpecified) {
                DomModifier.background(textStyle.background.dom)
            }
            .textAlign(textStyle.textAlign.dom)
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

                            element.parentHtmlElement?.style?.height = "auto"
                            height = max(element.scrollHeight, element.parentHtmlElement?.offsetHeight ?: 0).px.plus(14.px)
                            element.parentHtmlElement?.style?.height = height.toString()

                            onValueChange(it.value)
                        }
                    }
            )
        }

        label?.let {
            Label(
                attrs = Modifier
                    .dom
                    .classNames(BeerStyleSheet.fieldLabelParent)
                    .toAttrs()
            ) {
                it()
            }
        }

        if (supportingText != null) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .unwrap {
                        typeSafeClasses(TypeSafeClass(if (isError) "error" else "helper"))
                            .classNames(BeerStyleSheet.fieldSupportingParent)
                    }
            ) {
                supportingText()
            }
        }
    }
}