package io.kdomskia.compose.ui.resource

import org.jetbrains.compose.resources.DrawableResource

val DrawableResource.img: ImageResource.Local
    get() = ImageResource.Local(this)