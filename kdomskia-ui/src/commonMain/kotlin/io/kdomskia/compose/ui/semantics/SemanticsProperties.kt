package io.kdomskia.compose.ui.semantics

import androidx.compose.runtime.Immutable
import androidx.compose.ui.semantics.Role as SkiaRole

@Immutable
class Role(
    internal val _skia: SkiaRole
) {

    companion object {

        val Button: Role = Role(SkiaRole.Button)

        val Checkbox: Role = Role(SkiaRole.Checkbox)

        val Switch: Role = Role(SkiaRole.Switch)

        val RadioButton: Role = Role(SkiaRole.RadioButton)

        val Tab: Role = Role(SkiaRole.Tab)

        val Image: Role = Role(SkiaRole.Image)

        val DropdownList: Role = Role(SkiaRole.DropdownList)

        val ValuePicker: Role = Role(SkiaRole.ValuePicker)

        val Carousel: Role = Role(SkiaRole.Carousel)

    }

}