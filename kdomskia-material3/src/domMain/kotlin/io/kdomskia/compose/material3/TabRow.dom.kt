package io.kdomskia.compose.material3

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.kdomskia.compose.foundation.ScrollState
import io.kdomskia.compose.material3.beer.BeerTabRow
import io.kdomskia.compose.material3.css.beer.classes.BeerSizeClass
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.TabRowDefaults as SkiaTabRowDefaults

@Composable
actual fun PrimaryTabRow(
    selectedTabIndex: Int,
    modifier: Modifier,
    containerColor: Color,
    contentColor: Color,
    indicatorColor: Color,
    indicatorHeight: Dp,
    dividerColor: Color,
    dividerThickness: Dp,
    tabs: @Composable () -> Unit
) {
    BeerTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        isScrollable = false,
        classes = listOf(BeerSizeClass.Min),
        containerColor = containerColor,
        contentColor = contentColor,
        indicatorColor = indicatorColor,
        indicatorHeight = indicatorHeight,
        dividerColor = dividerColor,
        dividerThickness = dividerThickness,
        containerHorizontalPadding = 0.dp,
        tabs = tabs
    )
}

@Composable
actual fun SecondaryTabRow(
    selectedTabIndex: Int,
    modifier: Modifier,
    containerColor: Color,
    contentColor: Color,
    indicatorColor: Color,
    indicatorHeight: Dp,
    dividerColor: Color,
    dividerThickness: Dp,
    tabs: @Composable () -> Unit
) {
    BeerTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        isScrollable = false,
        containerColor = containerColor,
        contentColor = contentColor,
        indicatorColor = indicatorColor,
        indicatorHeight = indicatorHeight,
        dividerColor = dividerColor,
        dividerThickness = dividerThickness,
        containerHorizontalPadding = 0.dp,
        tabs = tabs
    )
}

@Composable
actual fun PrimaryScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier,
    scrollState: ScrollState,
    containerColor: Color,
    contentColor: Color,
    indicatorColor: Color,
    indicatorHeight: Dp,
    dividerColor: Color,
    dividerThickness: Dp,
    removeEdgePadding: Boolean,
    tabs: @Composable () -> Unit
) {
    BeerTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        isScrollable = true,
        classes = listOf(BeerSizeClass.Min),
        containerColor = containerColor,
        contentColor = contentColor,
        indicatorColor = indicatorColor,
        indicatorHeight = indicatorHeight,
        dividerColor = dividerColor,
        dividerThickness = dividerThickness,
        containerHorizontalPadding = if (removeEdgePadding)
            0.dp
        else
            SkiaTabRowDefaults.ScrollableTabRowEdgeStartPadding,
        tabs = tabs
    )
}

@Composable
actual fun SecondaryScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier,
    scrollState: ScrollState,
    containerColor: Color,
    contentColor: Color,
    indicatorColor: Color,
    indicatorHeight: Dp,
    dividerColor: Color,
    dividerThickness: Dp,
    removeEdgePadding: Boolean,
    tabs: @Composable () -> Unit
) {
    BeerTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        isScrollable = true,
        containerColor = containerColor,
        contentColor = contentColor,
        indicatorColor = indicatorColor,
        indicatorHeight = indicatorHeight,
        dividerColor = dividerColor,
        dividerThickness = dividerThickness,
        containerHorizontalPadding = if (removeEdgePadding)
            0.dp
        else
            SkiaTabRowDefaults.ScrollableTabRowEdgeStartPadding,
        tabs = tabs
    )
}