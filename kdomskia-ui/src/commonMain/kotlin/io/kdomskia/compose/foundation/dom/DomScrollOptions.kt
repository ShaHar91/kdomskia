package io.kdomskia.compose.foundation.dom

import androidx.compose.runtime.Immutable

@Immutable
data class DomScrollOptions(
    val target: DomScrollTarget,
    val overflow: DomOverflow = DomOverflow.Auto
)