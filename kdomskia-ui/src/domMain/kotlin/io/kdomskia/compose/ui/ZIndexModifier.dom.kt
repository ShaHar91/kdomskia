package io.kdomskia.compose.ui

import androidx.compose.runtime.Stable
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import kotlin.math.min

@Stable
actual fun Modifier.zIndex(zIndex: Float) = unwrap {
    zIndex(min(zIndex, Int.MAX_VALUE.toFloat()))
}

object ZIndexLayer {

    val layer0 = 0f..10f

    val layer1 = 11f..20f

    val layer2 = 21f..30f

    val layer3 = 31f..40f

    val layer4 = 41f..50f

}