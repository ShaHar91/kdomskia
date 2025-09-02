# Material3 Components

This document provides examples and usage of the supported Material3 components in Kdomskia.

Most parameters of the components are optional. They exist mainly for customization and usually can be omitted in simple use cases.

## Table of Contents
- [MaterialTheme](#materialtheme)
- [Text](#text)
- [Button](#button)
- [FloatingActionButton](#floatingactionbutton)
- [Icon](#icon)
- [TopAppBar](#topappbar)
- [NavigationDrawer](#navigationdrawer)
- [NavigationRail](#navigationrail)
- [Tabs](#tabs)
- [ProgressIndicator](#progressindicator)
- [Divider](#divider)
- [Surface](#surface)

---

## MaterialTheme

`MaterialTheme` is the entry point for applying a consistent design system across your app.  
It defines **colorScheme**, **typography**, and **shapes**, which can be customized or left as defaults.

```kotlin
import io.kdomskia.compose.material3.MaterialTheme
import io.kdomskia.compose.material3.lightColorScheme
import io.kdomskia.compose.material3.Typography
import io.kdomskia.compose.material3.Shapes

MaterialTheme(
    colorScheme = lightColorScheme(
        primary = Color.Blue,
        background = Color.White
    ),
    typography = Typography(
        displayLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 57.sp,
            lineHeight = 64.sp,
            letterSpacing = 0.sp,
        )
    ),
    shapes = Shapes(
        extraSmall = RoundedCornerShape(4.dp)
    )
) {
    // Add content here
}
```

## Text

The most basic way to display text.

```kotlin
import io.kdomskia.compose.material3.Text

Text(
    text = "Hello World",
    modifier = Modifier,
    color = Color.Black,
    fontSize = 16.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Bold,
    letterSpacing = 0.sp,
    textDecoration = null,
    textAlign = TextAlign.Center,
    lineHeight = 20.sp,
    maxLines = 2,
    style = LocalTextStyle.current
)
```

Usage with AnnotatedString:

```kotlin
Text(
    text = buildAnnotatedString {
        append("Hello ")
        withStyle(
            SpanStyle(fontWeight = FontWeight.W900)
        ) {
            append("Kdomskia")
        }
    }
)
```

## Button

These are the main button variations. They differ by style (filled, outlined, text-only, or elevated).

```kotlin
import io.kdomskia.compose.material3.Button
import io.kdomskia.compose.material3.OutlinedButton
import io.kdomskia.compose.material3.TextButton
import io.kdomskia.compose.material3.ElevatedButton

Column {
    Button(
        onClick = { /* Action */ },
        modifier = Modifier,
        enabled = true,
        shape = ButtonDefaults.shape,
        colors = ButtonDefaults.buttonColors().copy(containerColor = Color.Black),
        contentPadding = ButtonDefaults.ContentPadding
    ) {
        Text("Filled Button")
    }

    OutlinedButton(
        onClick = { /* Action */ },
        modifier = Modifier,
        enabled = true,
        shape = ButtonDefaults.outlinedShape,
        colors = ButtonDefaults.outlinedButtonColors(),
        border = ButtonDefaults.outlinedButtonBorder(enabled = true),
        contentPadding = ButtonDefaults.ContentPadding
    ) {
        Text("Outlined Button")
    }

    TextButton(
        onClick = { /* Action */ },
        modifier = Modifier,
        enabled = true,
        shape = ButtonDefaults.textShape,
        colors = ButtonDefaults.textButtonColors(),
        contentPadding = ButtonDefaults.TextButtonContentPadding
    ) {
        Text("Text Button")
    }

    ElevatedButton(
        onClick = { /* Action */ },
        modifier = Modifier,
        enabled = true,
        shape = ButtonDefaults.elevatedShape,
        colors = ButtonDefaults.elevatedButtonColors(),
        contentPadding = ButtonDefaults.ContentPadding
    ) {
        Text("Elevated Button")
    }
}
```

## FloatingActionButton

Floating action buttons are used for primary actions. The extended version allows text and an icon.

```kotlin
import io.kdomskia.compose.material3.FloatingActionButton
import io.kdomskia.compose.material3.ExtendedFloatingActionButton

Column {
    FloatingActionButton(
        onClick = { /* Action */ },
        modifier = Modifier,
        shape = FloatingActionButtonDefaults.shape,
        containerColor = FloatingActionButtonDefaults.containerColor,
        contentColor = contentColorFor(FloatingActionButtonDefaults.containerColor)
    ) {
        Icon(img = Res.drawable.add.img, contentDescription = "Add")
    }

    ExtendedFloatingActionButton(
        text = { Text("Add Item") },
        icon = { Icon(img = Res.drawable.add.img, contentDescription = "Add") },
        onClick = { /* Action */ },
        modifier = Modifier,
        expanded = true,
        shape = FloatingActionButtonDefaults.extendedFabShape,
        containerColor = FloatingActionButtonDefaults.containerColor,
        contentColor = contentColorFor(FloatingActionButtonDefaults.containerColor)
    )
}
```

## Icon

```kotlin
import io.kdomskia.compose.material3.Icon
import io.kdomskia.compose.material3.IconButton

IconButton(
    onClick = { /* Search */ },
    enabled = true,
    colors = IconButtonDefaults.iconButtonColors().copy(
        containerColor = Color.Black
    ),
    shape = IconButtonDefaults.standardShape
) {
    Icon(
        img = Res.drawable.search.img, 
        contentDescription = "Search",
        tint = Color.Red
    )
}
```

## TopAppBar

A top app bar provides structure and actions at the top of the screen.

```kotlin
import io.kdomskia.compose.material3.TopAppBar

TopAppBar(
    title = { Text("My App") },
    modifier = Modifier,
    navigationIcon = {
        IconButton(onClick = { /* Back */ }) {
            Icon(img = Res.drawable.arrow_back.img, contentDescription = "Back")
        }
    },
    actions = {
        IconButton(onClick = { /* Search */ }) {
            Icon(img = Res.drawable.search.img, contentDescription = "Search")
        }
    },
    titleHorizontalAlignment = Alignment.Start,
    expandedHeight = TopAppBarDefaults.TopAppBarExpandedHeight,
    windowInsets = TopAppBarDefaults.windowInsets,
    colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color.Black)
)
```

## NavigationDrawer

A modal navigation drawer slides in from the side, providing navigation options.

```kotlin
import io.kdomskia.compose.material3.ModalNavigationDrawer
import io.kdomskia.compose.material3.ModalDrawerSheet
import io.kdomskia.compose.material3.NavigationDrawerItem

val drawerState = rememberDrawerState(DrawerValue.Closed)
val scope = rememberCoroutineScope()

ModalNavigationDrawer(
    drawerContent = {
        ModalDrawerSheet(
            modifier = Modifier,
            drawerShape = DrawerDefaults.shape,
            drawerContainerColor = DrawerDefaults.modalContainerColor,
            drawerContentColor = contentColorFor(DrawerDefaults.modalContainerColor),
            drawerTonalElevation = DrawerDefaults.ModalDrawerElevation,
            windowInsets = DrawerDefaults.windowInsets
        ) {
            NavigationDrawerItem(
                label = { Text("Home") },
                selected = true,
                onClick = { /* Navigate */ },
                icon = { Icon(img = Res.drawable.home.img, contentDescription = "Home") },
                badge = { Text("New") },
                shape = DrawerDefaults.ActiveIndicatorShape,
                colors = NavigationDrawerItemDefaults.colors(
                    selectedContainerColor = Color.Gray
                )
            )
        }
    },
    modifier = Modifier,
    drawerState = drawerState,
    gesturesEnabled = true,
    scrimColor = DrawerDefaults.scrimColor
) {
    Button(
        onClick = {
            scope.launch {
                drawerState.open()
            }
        }
    ) {
        Text("Open Drawer")
    }
}
```

## NavigationRail

A navigation rail is used on larger screens to provide persistent navigation.

```kotlin
import io.kdomskia.compose.material3.NavigationRail
import io.kdomskia.compose.material3.NavigationRailItem

NavigationRail(
    modifier = Modifier,
    containerColor = NavigationRailDefaults.ContainerColor,
    contentColor = contentColorFor(NavigationRailDefaults.ContainerColor),
    header = { Text("Header") },
    windowInsets = NavigationRailDefaults.windowInsets
) {
    NavigationRailItem(
        selected = true,
        onClick = { /* Navigate */ },
        icon = { Icon(img = Res.drawable.home.img, contentDescription = "Home") },
        modifier = Modifier,
        enabled = true,
        label = { Text("Home") },
        alwaysShowLabel = true,
        colors = NavigationRailItemDefaults.colors()
    )
}
```

## Tabs

Tabs organize content across categories.

```kotlin
import io.kdomskia.compose.material3.PrimaryTabRow
import io.kdomskia.compose.material3.Tab

val selectedIndex = 0

PrimaryTabRow(
    selectedTabIndex = selectedIndex,
    modifier = Modifier,
    containerColor = TabRowDefaults.primaryContainerColor,
    contentColor = TabRowDefaults.primaryContentColor,
    indicatorColor = MaterialTheme.colorScheme.primary,
    indicatorHeight = TabRowDefaults.activeIndicatorHeight,
    dividerColor = DividerDefaults.color,
    dividerThickness = DividerDefaults.Thickness
) {
    Tab(
        selected = true,
        onClick = { /* Change tab */ },
        modifier = Modifier,
        enabled = true,
        text = { Text("Tab 1") },
        icon = { Icon(img = Res.drawable.home.img, contentDescription = "Home") },
        selectedContentColor = LocalContentColor.current,
        unselectedContentColor = Color.Gray
    )
}
```

## ProgressIndicator

```kotlin
import io.kdomskia.compose.material3.CircularProgressIndicator

CircularProgressIndicator(
    modifier = Modifier,
    color = ProgressIndicatorDefaults.circularColor,
    strokeWidth = ProgressIndicatorDefaults.CircularStrokeWidth
)
```

## Divider

```kotlin
import io.kdomskia.compose.material3.HorizontalDivider
import io.kdomskia.compose.material3.VerticalDivider

HorizontalDivider(
    modifier = Modifier.fillMaxWidth()
)

VericalDivider(
    modifier = Modifier.fillMaxHeight()
)
```

## Surface

A surface is a container that applies background, elevation, and other styling.

```kotlin
import io.kdomskia.compose.material3.Surface

Surface(
    modifier = Modifier,
    shape = RectangleShape,
    color = MaterialTheme.colorScheme.surface,
    contentColor = contentColorFor(MaterialTheme.colorScheme.surface),
    tonalElevation = 2.dp,
    shadowElevation = 4.dp,
    border = BorderStroke(1.dp, Color.Gray)
) {
    Text("Surface content")
}
```