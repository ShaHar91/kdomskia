package io.kdomskia.compose.material3

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.kdomskia.compose.foundation.ScrollState
import io.kdomskia.compose.ui.Modifier
import androidx.compose.material3.PrimaryScrollableTabRow as SkiaPrimaryScrollableTabRow
import androidx.compose.material3.PrimaryTabRow as SkiaPrimaryTabRow
import androidx.compose.material3.SecondaryScrollableTabRow as SkiaSecondaryScrollableTabRow
import androidx.compose.material3.SecondaryTabRow as SkiaSecondaryTabRow
import androidx.compose.material3.TabRowDefaults as SkiaTabRowDefaults
import androidx.compose.ui.Modifier as SkiaModifier

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
    SkiaPrimaryTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier.skia,
        containerColor = containerColor,
        contentColor = contentColor,
        indicator = {
            TabRowDefaults.PrimaryIndicator(
                modifier = SkiaModifier.tabIndicatorOffset(selectedTabIndex, matchContentSize = true),
                width = Dp.Unspecified,
                height = indicatorHeight,
                color = indicatorColor
            )
        },
        divider = {
            HorizontalDivider(
                thickness = dividerThickness,
                color = dividerColor
            )
        },
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
    SkiaSecondaryTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier.skia,
        containerColor = containerColor,
        contentColor = contentColor,
        indicator = {
            TabRowDefaults.SecondaryIndicator(
                modifier = SkiaModifier.tabIndicatorOffset(selectedTabIndex, matchContentSize = false),
                height = indicatorHeight,
                color = indicatorColor
            )
        },
        divider = {
            HorizontalDivider(
                thickness = dividerThickness,
                color = dividerColor
            )
        },
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
    SkiaPrimaryScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier.skia,
        scrollState = scrollState.skia,
        containerColor = containerColor,
        contentColor = contentColor,
        edgePadding = if (removeEdgePadding) 0.dp else SkiaTabRowDefaults.ScrollableTabRowEdgeStartPadding,
        indicator = {
            TabRowDefaults.PrimaryIndicator(
                modifier = SkiaModifier.tabIndicatorOffset(selectedTabIndex, matchContentSize = true),
                width = Dp.Unspecified,
                height = indicatorHeight,
                color = indicatorColor
            )
        },
        divider = {
            HorizontalDivider(
                thickness = dividerThickness,
                color = dividerColor
            )
        },
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
    SkiaSecondaryScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier.skia,
        scrollState = scrollState.skia,
        containerColor = containerColor,
        contentColor = contentColor,
        edgePadding = if (removeEdgePadding) 0.dp else SkiaTabRowDefaults.ScrollableTabRowEdgeStartPadding,
        indicator = {
            TabRowDefaults.SecondaryIndicator(
                modifier = SkiaModifier.tabIndicatorOffset(selectedTabIndex, matchContentSize = false),
                height = indicatorHeight,
                color = indicatorColor
            )
        },
        divider = {
            HorizontalDivider(
                thickness = dividerThickness,
                color = dividerColor
            )
        },
        tabs = tabs
    )
}