# Foundation Components

This document provides an overview of the main layout components available in the Kdomskia, along with practical usage examples.

These components allow you to build responsive, flexible, and adaptive user interfaces, leveraging the declarative power of Compose Multiplatform.

## Table of Contents
- [Box](#box)
- [Column](#column)
- [Row](#row)
- [BoxWithConstraints](#boxwithconstraints)
- [ViewportContainer](#viewportcontainer)
- [Image](#image)
- [Spacer](#spacer)
- [FlowRow](#flowrow)
- [HorizontalPager](#horizontalpager)
- [LazyVerticalStaggeredGrid](#lazyverticalstaggeredgrid)

### Box

`Box` is the most basic layout container. It allows stacking elements on top of each other and optionally aligning its children within the container.

```kotlin
import io.kdomskia.compose.foundation.layout.Box
import io.kdomskia.compose.ui.Alignment

Box(
    modifier = Modifier,
    contentAlignment = Alignment.Center
) {
    //Place elements here
}
```

### Column

`Column` arranges its children vertically in order. You can control how elements are aligned horizontally and spaced vertically.

```kotlin
import io.kdomskia.compose.foundation.layout.Arrangement
import io.kdomskia.compose.foundation.layout.Column
import io.kdomskia.compose.ui.Alignment

Column(
    modifier = Modifier,
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.Start
) {
    //Place elements here
}
```

### Row

`Row` arranges its children horizontally in a single line. It provides alignment and spacing options for precise control over layout.

```kotlin
import io.kdomskia.compose.foundation.layout.Arrangement
import io.kdomskia.compose.foundation.layout.Row
import io.kdomskia.compose.ui.Alignment

Row(
    modifier = Modifier,
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.Top
) {
    //Place elements here
}
```

### BoxWithConstraints

`BoxWithConstraints` is similar to `Box`, but it also provides information about the maximum width and height available, making it useful for responsive layouts.

```kotlin
import io.kdomskia.compose.foundation.layout.BoxWithConstraints
import io.kdomskia.compose.ui.Alignment

BoxWithConstraints(
    modifier = Modifier,
    contentAlignment = Alignment.Center
) {
    val maxWidth = this.maxWidth
    val maxHeight = this.maxHeight
    //Place elements here
}
```

### ViewportContainer

`ViewportContainer` is a container that can control how its child content is displayed relative to the visible viewport. It is often used to manage alignment and positioning of scrollable or bounded content.

```kotlin
import io.kdomskia.compose.foundation.layout.ViewportContainer
import io.kdomskia.compose.ui.Alignment

ViewportContainer(
    modifier = Modifier,
    contentAlignment = Alignment.BottomEnd
) {
    //Place elements here
}
```

### Image

`Image` is used to render images such as SVG, PNG, or other drawable resources. Resources can be referenced using the `img` extension property.

```kotlin
import io.kdomskia.compose.foundation.Image
import io.kdomskia.compose.ui.resource.img

Image(
    img = Res.drawable.my_image.img,
    modifier = Modifier,
    contentDescription = null
)
```

### Spacer

`Spacer` is a composable used to add empty space inside layouts. It is especially useful inside `Row` or `Column` to create flexible spacing between elements.

```kotlin
import io.kdomskia.compose.foundation.layout.Spacer

Column(
    modifier = Modifier.fillMaxSize()
) {
    Spacer(modifier = Modifier.weight(0.7f))
    //Place elements here
    Spacer(modifier = Modifier.weight(0.3f))
}
```

### FlowRow

`FlowRow` arranges its children horizontally and wraps them onto the next line when the current line is filled. This is useful for responsive UIs or tag-like layouts.

```kotlin
import io.kdomskia.compose.foundation.layout.Arrangement
import io.kdomskia.compose.foundation.layout.FlowRow
import io.kdomskia.compose.ui.Alignment

FlowRow(
    modifier = Modifier,
    horizontalArrangement = Arrangement.spacedBy(
        space = 8.dp,
        alignment = Alignment.CenterHorizontally
    )
) {
    //Place elements here
}
```

### HorizontalPager

`HorizontalPager` is a composable that allows creating horizontal pages. It supports programmatic navigation.

```kotlin
import io.kdomskia.compose.foundation.HorizontalPager
import io.kdomskia.compose.foundation.rememberPagerState

HorizontalPager(
    state = rememberPagerState { 2 },
    modifier = Modifier
) { index ->
    when (index) {
        0 -> pageOne()
        1 -> pageTwo()
    }
}

//Change the current page
val scope = rememberCoroutineScope()
scope.launch {
    state.animateScrollToPage(1)
}
```

### LazyVerticalStaggeredGrid

`LazyVerticalStaggeredGrid` arranges items in a vertical grid where each column can have different item heights.

```kotlin
import io.kdomskia.compose.foundation.dom.DomScrollOptions
import io.kdomskia.compose.foundation.dom.DomScrollTarget
import io.kdomskia.compose.foundation.layout.Arrangement
import io.kdomskia.compose.foundation.layout.PaddingValues
import io.kdomskia.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import io.kdomskia.compose.foundation.lazy.staggeredgrid.StaggeredGridCells

LazyVerticalStaggeredGrid(
    columns = StaggeredGridCells.Fixed(count = 4),
    modifier = Modifier,
    contentPadding = PaddingValues(all = 16.dp),
    verticalItemSpacing = 16.dp,
    horizontalArrangement = Arrangement.spacedBy(16.dp),
    domScrollOptions = DomScrollOptions(
        target = DomScrollTarget.Window
    )
) {
    //Place elements here
}
```
