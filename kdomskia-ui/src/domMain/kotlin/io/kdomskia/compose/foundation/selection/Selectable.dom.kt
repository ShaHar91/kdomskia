package io.kdomskia.compose.foundation.selection

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.compose.ui.thenIf
import io.kdomskia.compose.foundation.clickable
import io.kdomskia.compose.ui.DomModifier
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.semantics.Role

actual fun Modifier.selectable(
    selected: Boolean,
    enabled: Boolean,
    role: Role?,
    onClick: () -> Unit
) = unwrap {
    selectable(
        selected = selected,
        enabled = enabled,
        role = role,
        disableUserSelect = true,
        onClick = onClick
    )
}

fun DomModifier.selectable(
    selected: Boolean,
    enabled: Boolean,
    role: Role? = null,
    cursor: Cursor? = null,
    disableUserSelect: Boolean,
    onClick: () -> Unit
): DomModifier = clickable(
    enabled = enabled,
    cursor = cursor,
    role = role,
    onClick = onClick
).thenIf(disableUserSelect) {
    userSelect(UserSelect.None)
}