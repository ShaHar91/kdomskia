package io.kdomskia.compose.material3

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import io.kdomskia.compose.foundation.layout.PaddingValues
import io.kdomskia.compose.foundation.layout.RowScope
import io.kdomskia.compose.material3.beer.BeerButton
import io.kdomskia.compose.material3.css.beer.classes.BeerButtonElevateClass
import io.kdomskia.compose.ui.Modifier

@Composable
actual fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    colors: ButtonColors,
    contentPadding: PaddingValues,
    content: @Composable RowScope.() -> Unit
) {
    BeerButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        containerColor = colors.containerColor,
        contentColor = colors.contentColor,
        contentPadding = contentPadding,
        shape = shape,
        textStyle = MaterialTheme.typography.labelLarge,
        content = content
    )
}

@Composable
actual fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    colors: ButtonColors,
    border: BorderStroke?,
    contentPadding: PaddingValues,
    content: @Composable RowScope.() -> Unit
) {
    BeerButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        containerColor = colors.containerColor,
        contentColor = colors.contentColor,
        contentPadding = contentPadding,
        border = border,
        shape = shape,
        textStyle = MaterialTheme.typography.labelLarge,
        content = content
    )
}

@Composable
actual fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    colors: ButtonColors,
    border: BorderStroke?,
    contentPadding: PaddingValues,
    content: @Composable (RowScope.() -> Unit)
) {
    BeerButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        containerColor = colors.containerColor,
        contentColor = colors.contentColor,
        contentPadding = contentPadding,
        border = border,
        shape = shape,
        textStyle = MaterialTheme.typography.labelLarge,
        content = content
    )
}

@Composable
actual fun ElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    shape: Shape,
    colors: ButtonColors,
    contentPadding: PaddingValues,
    content: @Composable RowScope.() -> Unit
) {
    BeerButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        containerColor = colors.containerColor,
        contentColor = colors.contentColor,
        contentPadding = contentPadding,
        shape = shape,
        textStyle = MaterialTheme.typography.labelLarge,
        buttonElevate = BeerButtonElevateClass.Small,
        content = content
    )
}