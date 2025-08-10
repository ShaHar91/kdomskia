package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.kdomskia.compose.foundation.ScrollState
import io.kdomskia.compose.foundation.rememberScrollState
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.TabRowDefaults as SkiaTabRowDefaults

@Composable
expect fun PrimaryTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = TabRowDefaults.primaryContainerColor,
    contentColor: Color = TabRowDefaults.primaryContentColor,
    indicatorColor: Color = MaterialTheme.colorScheme.primary,
    indicatorHeight: Dp = TabRowDefaults.activeIndicatorHeight,
    dividerColor: Color = DividerDefaults.color,
    dividerThickness: Dp = DividerDefaults.Thickness,
    tabs: @Composable () -> Unit
)

@Composable
expect fun SecondaryTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = TabRowDefaults.secondaryContainerColor,
    contentColor: Color = TabRowDefaults.secondaryContentColor,
    indicatorColor: Color = MaterialTheme.colorScheme.primary,
    indicatorHeight: Dp = TabRowDefaults.activeIndicatorHeight,
    dividerColor: Color = DividerDefaults.color,
    dividerThickness: Dp = DividerDefaults.Thickness,
    tabs: @Composable () -> Unit
)

@Composable
expect fun PrimaryScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    containerColor: Color = TabRowDefaults.primaryContainerColor,
    contentColor: Color = TabRowDefaults.primaryContentColor,
    indicatorColor: Color = MaterialTheme.colorScheme.primary,
    indicatorHeight: Dp = TabRowDefaults.activeIndicatorHeight,
    dividerColor: Color = DividerDefaults.color,
    dividerThickness: Dp = DividerDefaults.Thickness,
    removeEdgePadding: Boolean = false,
    tabs: @Composable () -> Unit
)

@Composable
expect fun SecondaryScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    containerColor: Color = TabRowDefaults.secondaryContainerColor,
    contentColor: Color = TabRowDefaults.secondaryContentColor,
    indicatorColor: Color = MaterialTheme.colorScheme.primary,
    indicatorHeight: Dp = TabRowDefaults.activeIndicatorHeight,
    dividerColor: Color = DividerDefaults.color,
    dividerThickness: Dp = DividerDefaults.Thickness,
    removeEdgePadding: Boolean = false,
    tabs: @Composable () -> Unit
)

object TabRowDefaults {

    val activeIndicatorHeight: Dp = 3.dp

    val primaryContainerColor: Color
        @Composable
        get() = SkiaTabRowDefaults.primaryContainerColor

    val primaryContentColor: Color
        @Composable
        get() = SkiaTabRowDefaults.primaryContentColor

    val secondaryContainerColor: Color
        @Composable
        get() = SkiaTabRowDefaults.secondaryContainerColor

    val secondaryContentColor: Color
        @Composable
        get() = SkiaTabRowDefaults.secondaryContentColor

}