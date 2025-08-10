package io.kdomskia.compose.foundation

import io.kdomskia.compose.ui.semantics.Role
import io.kdomskia.compose.ui.Modifier

expect fun Modifier.clickable(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit
): Modifier