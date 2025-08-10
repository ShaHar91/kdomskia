package io.kdomskia.compose.ui.layout

import androidx.compose.ui.unit.IntSize

interface LayoutCoordinates {

    val size: IntSize

}

internal class LayoutCoordinatesImpl(
    override val size: IntSize
) : LayoutCoordinates