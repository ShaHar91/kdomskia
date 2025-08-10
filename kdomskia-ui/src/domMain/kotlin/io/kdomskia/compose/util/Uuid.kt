package io.kdomskia.compose.util

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
fun generateUuid(): String = Uuid.random().toString()