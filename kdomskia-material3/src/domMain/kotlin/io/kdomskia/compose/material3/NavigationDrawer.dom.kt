package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.varabyte.kobweb.compose.dom.refScope
import io.kdomskia.compose.css.TypeSafeClass
import io.kdomskia.compose.css.animation.FadeTarget
import io.kdomskia.compose.css.animation.SlideLeftToRight
import io.kdomskia.compose.css.animation.SlideRightToLeft
import io.kdomskia.compose.css.animation.fade
import io.kdomskia.compose.css.animation.slide
import io.kdomskia.compose.css.animation.slideAwaitingCompletion
import io.kdomskia.compose.extension.query
import io.kdomskia.compose.foundation.background
import io.kdomskia.compose.foundation.clickable
import io.kdomskia.compose.foundation.layout.Box
import io.kdomskia.compose.foundation.layout.Column
import io.kdomskia.compose.foundation.layout.ColumnScope
import io.kdomskia.compose.foundation.layout.Row
import io.kdomskia.compose.foundation.layout.Spacer
import io.kdomskia.compose.foundation.layout.ViewportContainer
import io.kdomskia.compose.foundation.layout.WindowInsets
import io.kdomskia.compose.foundation.layout.fillMaxSize
import io.kdomskia.compose.foundation.layout.fillMaxWidth
import io.kdomskia.compose.foundation.layout.fillViewportHeight
import io.kdomskia.compose.foundation.layout.heightIn
import io.kdomskia.compose.foundation.layout.padding
import io.kdomskia.compose.foundation.layout.width
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.ui.Alignment
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.ZIndexLayer
import io.kdomskia.compose.ui.draw.clip
import kotlinx.coroutines.launch
import org.w3c.dom.HTMLElement
import com.varabyte.kobweb.compose.foundation.layout.Box as DomBox

@Stable
actual class DrawerState actual constructor(
    initialValue: DrawerValue,
    confirmStateChange: (DrawerValue) -> Boolean
) {

    private var _currentValue: DrawerValue by mutableStateOf(initialValue)

    actual val isOpen: Boolean
        get() = currentValue == DrawerValue.Open

    actual val isClosed: Boolean
        get() = currentValue == DrawerValue.Closed

    actual val currentValue: DrawerValue
        get() = _currentValue

    actual suspend fun open() {
        _currentValue = DrawerValue.Open
    }

    actual suspend fun close() {
        _currentValue = DrawerValue.Closed
    }

    actual companion object {

        actual fun Saver(confirmStateChange: (DrawerValue) -> Boolean) =
            Saver<DrawerState, DrawerValue>(
                save = { it.currentValue },
                restore = { DrawerState(it, confirmStateChange) },
            )

    }

}

@Composable
actual fun ModalNavigationDrawer(
    drawerContent: @Composable (() -> Unit),
    modifier: Modifier,
    drawerState: DrawerState,
    gesturesEnabled: Boolean,
    scrimColor: Color,
    content: @Composable (() -> Unit)
) {
    val scope = rememberCoroutineScope()
    var element by remember {
        mutableStateOf<HTMLElement?>(null)
    }

    if (drawerState.isOpen) {
        ViewportContainer(
            zIndex = ZIndexLayer.layer4.start,
            contentAlignment = Alignment.Center
        ) {
            DomBox(
                modifier = modifier
                    .padding(0.dp)
                    .dom,
                ref = refScope {
                    ref(Unit) {
                        element = it
                    }
                }
            ) {
                var fadeDirection by remember {
                    mutableStateOf(FadeTarget.In)
                }
                Spacer(
                    modifier = Modifier
                        .clickable {
                            fadeDirection = FadeTarget.Out
                            scope.launch {
                                element
                                    ?.query(DrawerSheet)
                                    ?.slideAwaitingCompletion(SlideRightToLeft.Out)
                                drawerState.close()
                            }
                        }
                        .fillMaxSize()
                        .background(scrimColor)
                        .unwrap { fade(fadeDirection) }
                )
                drawerContent()
            }
        }
    }

    content()
}

@Composable
actual fun ModalDrawerSheet(
    modifier: Modifier,
    drawerShape: Shape,
    drawerContainerColor: Color,
    drawerContentColor: Color,
    drawerTonalElevation: Dp,
    windowInsets: WindowInsets,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Column(
        modifier = modifier
            .width(DrawerDefaults.MaxDrawerWidth)
            .clip(drawerShape)
            .background(drawerContainerColor)
            .fillViewportHeight()
            .unwrap {
                boxShadow(shadowElevation = drawerTonalElevation.value)
                    .typeSafeClasses(DrawerSheet)
                    .slide(SlideLeftToRight.In)
            },
        content = {
            ProvideContentColor(drawerContentColor) {
                content()
            }
        }
    )
}

@Composable
actual fun NavigationDrawerItem(
    label: @Composable (() -> Unit),
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier,
    icon: @Composable (() -> Unit)?,
    badge: @Composable (() -> Unit)?,
    shape: Shape,
    colors: NavigationDrawerItemColors
) {
    Surface(
        selected = selected,
        onClick = onClick,
        modifier = modifier
            .heightIn(min = DrawerDefaults.ActiveIndicatorHeight)
            .fillMaxWidth(),
        shape = shape,
        color = colors.containerColor(selected).value
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (icon != null) {
                val iconColor = colors.iconColor(selected).value
                ProvideContentColor(color = iconColor, content = icon)
                Spacer(Modifier.width(12.dp))
            }
            Box(Modifier.weight(1f)) {
                val labelColor = colors.textColor(selected).value
                ProvideContentColor(color = labelColor, content = label)
            }
            if (badge != null) {
                Spacer(Modifier.width(12.dp))
                val badgeColor = colors.badgeColor(selected).value
                ProvideContentColor(color = badgeColor, content = badge)
            }
        }
    }
}

private val DrawerSheet = TypeSafeClass("drawer-sheet")