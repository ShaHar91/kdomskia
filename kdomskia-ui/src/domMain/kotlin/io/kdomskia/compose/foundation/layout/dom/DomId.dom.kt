package io.kdomskia.compose.foundation.layout.dom

import io.kdomskia.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.id

actual fun Modifier.domId(id: String) = unwrap { id(value = id) }