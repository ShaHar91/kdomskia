package io.kdomskia.compose.foundation.selection

import androidx.compose.foundation.selection.selectable
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.semantics.Role
import io.kdomskia.compose.ui.semantics.skia

actual fun Modifier.selectable(
    selected: Boolean,
    enabled: Boolean,
    role: Role?,
    onClick: () -> Unit
) = unwrap {
    selectable(
        selected = selected,
        enabled = enabled,
        role = role?.skia,
        interactionSource = null,
        onClick = onClick
    )
}