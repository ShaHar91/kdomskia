package io.kdomskia.compose.ui.layout

import androidx.compose.runtime.Stable
import com.varabyte.kobweb.compose.css.ObjectFit

@Stable
val ContentScale.dom: ObjectFit
    get() = when (this) {
        ContentScale.Crop -> ObjectFit.Cover
        ContentScale.Fit -> ObjectFit.Contain
        ContentScale.FillHeight -> ObjectFit.Cover
        ContentScale.FillWidth -> ObjectFit.Cover
        ContentScale.Inside -> ObjectFit.ScaleDown
        ContentScale.None -> ObjectFit.None
        ContentScale.FillBounds -> ObjectFit.Fill
        else -> ObjectFit.None
    }