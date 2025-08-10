package io.kdomskia.compose.material3

import io.kdomskia.compose.foundation.layout.WindowInsets
import io.kdomskia.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.foundation.background
import io.kdomskia.compose.foundation.layout.Arrangement
import io.kdomskia.compose.foundation.layout.Column
import io.kdomskia.compose.foundation.layout.ColumnScope
import io.kdomskia.compose.foundation.layout.PaddingValues
import io.kdomskia.compose.foundation.layout.Spacer
import io.kdomskia.compose.foundation.layout.defaultMinSize
import io.kdomskia.compose.foundation.layout.fillMaxHeight
import io.kdomskia.compose.foundation.layout.height
import io.kdomskia.compose.foundation.layout.padding
import io.kdomskia.compose.foundation.layout.widthIn
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.material3.beer.BeerButton
import io.kdomskia.compose.material3.css.beer.classes.BeerNavigationClass
import io.kdomskia.compose.material3.internal.ProvideContentColorTextStyle
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.dom.Nav

@Composable
actual fun NavigationRail(
    modifier: Modifier,
    containerColor: Color,
    contentColor: Color,
    header: @Composable (ColumnScope.() -> Unit)?,
    windowInsets: WindowInsets,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Nav(
        attrs = modifier
            .background(containerColor)
            .dom
            .typeSafeClasses(BeerNavigationClass.Left)
            .gap(0.dp.dom)
            .minWidth(0.dp.dom)
            .padding(0.dp.dom)
            .toAttrs()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .widthIn(min = NavigationRailDefaults.NarrowContainerWidth)
                .padding(vertical = NavigationRailDefaults.VerticalPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(NavigationRailDefaults.VerticalPadding),
        ) {
            val header = header
            if (header != null) {
                header()
                Spacer(Modifier.height(NavigationRailDefaults.HeaderPadding))
            }
            content()
        }
    }
}

@Composable
actual fun NavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    label: @Composable (() -> Unit)?,
    alwaysShowLabel: Boolean,
    colors: NavigationRailItemColors
) {
    val iconColor = colors.iconColor(selected = selected, enabled = enabled)
    val iconContainerColor = if (selected) colors.indicatorColor else Color.Transparent
    val textColor = colors.textColor(selected = selected, enabled = enabled)
    val showLabel = label != null && (selected || alwaysShowLabel)
    val verticalPadding = if (showLabel)
        NavigationRailItemDefaults.VerticalPadding
    else
        NavigationRailItemDefaults.VerticalPaddingNoLabel

    Column(
        modifier = Modifier.padding(vertical = verticalPadding),
        verticalArrangement = Arrangement.spacedBy(NavigationRailDefaults.IconLabelSpace),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BeerButton(
            onClick = onClick,
            modifier = Modifier
                .defaultMinSize(minHeight = NavigationRailItemDefaults.Height)
                .widthIn(min = NavigationRailItemDefaults.Width),
            enabled = enabled,
            containerColor = iconContainerColor,
            contentColor = iconColor,
            contentPadding = PaddingValues(0.dp),
            shape = CircleShape
        ) {
            icon()
        }
        if (showLabel) {
            ProvideContentColorTextStyle(
                contentColor = textColor,
                textStyle = NavigationRailItemDefaults.LabelTextFont,
                content = label
            )
        }
    }
}