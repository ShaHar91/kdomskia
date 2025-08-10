package io.kdomskia.compose.foundation

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.thenIfNotNull
import io.kdomskia.annotation.InternalKdomskiaApi
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.semantics.Role

actual fun Modifier.clickable(
    enabled: Boolean,
    onClickLabel: String?,
    role: Role?,
    onClick: () -> Unit
): Modifier = unwrap {
    clickable(
        enabled = enabled,
        role = role,
        onClick = onClick
    )
}

fun DomModifier.clickable(
    enabled: Boolean,
    cursor: Cursor? = null,
    role: Role? = null,
    onClick: () -> Unit
): DomModifier = onClick {
    if (enabled)
        onClick()
}.thenIfNotNull(cursor) {
    cursor(it)
}.thenIfNotNull(ClickableModifierHolder.modifier) {
    thenIf(role == Role.Button) {
        then(it)
    }
}

@InternalKdomskiaApi
object ClickableModifierHolder {

    var modifier: DomModifier? = null

}