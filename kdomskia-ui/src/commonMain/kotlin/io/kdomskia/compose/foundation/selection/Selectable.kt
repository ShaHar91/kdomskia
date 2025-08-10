package io.kdomskia.compose.foundation.selection

import io.kdomskia.compose.ui.semantics.Role
import io.kdomskia.compose.ui.Modifier

expect fun Modifier.selectable(
    selected: Boolean,
    enabled: Boolean = true,
    role: Role? = null,
    onClick: () -> Unit,
): Modifier