package io.kdomskia.compose.foundation

import androidx.compose.foundation.clickable
import io.kdomskia.compose.ui.semantics.Role
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.semantics.skia

actual fun Modifier.clickable(
    enabled: Boolean,
    onClickLabel: String?,
    role: Role?,
    onClick: () -> Unit
): Modifier = unwrap {
    clickable(
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role?.skia,
        onClick = onClick
    )
}