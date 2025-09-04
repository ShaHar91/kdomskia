package io.kdomskia.compose.material3.beer

import androidx.compose.runtime.Composable
import io.kdomskia.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.varabyte.kobweb.compose.ui.modifiers.gridArea
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.toAttrs
import io.kdomskia.compose.foundation.layout.Arrangement
import io.kdomskia.compose.foundation.layout.Box
import io.kdomskia.compose.foundation.layout.Column
import io.kdomskia.compose.foundation.layout.Row
import io.kdomskia.compose.foundation.layout.RowScope
import io.kdomskia.compose.foundation.layout.Spacer
import io.kdomskia.compose.foundation.layout.fillMaxWidth
import io.kdomskia.compose.foundation.layout.padding
import io.kdomskia.compose.foundation.layout.width
import io.kdomskia.compose.foundation.typeSafeClasses
import io.kdomskia.compose.material3.MaterialTheme
import io.kdomskia.compose.material3.ProvideContentColor
import io.kdomskia.compose.material3.ProvideTextStyle
import io.kdomskia.compose.material3.TopAppBarColors
import io.kdomskia.compose.material3.css.Variable
import io.kdomskia.compose.material3.css.beer.classes.BeerColorClass
import io.kdomskia.compose.ui.Modifier
import io.kdomskia.compose.ui.graphics.dom
import io.kdomskia.compose.ui.unit.dom
import org.jetbrains.compose.web.dom.Header

@Composable
fun BeerTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    titleHorizontalAlignment: Alignment.Horizontal,
    expandedHeight: Dp,
    colors: TopAppBarColors
) {
    @Composable
    fun navigationContainer() {
        ProvideContentColor(colors.navigationIconContentColor) {
            navigationIcon()
        }
        Spacer(modifier = Modifier.width(8.dp))
    }

    @Composable
    fun titleContainer(
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = titleHorizontalAlignment
        ) {
            ProvideContentColor(colors.titleContentColor) {
                ProvideTextStyle(MaterialTheme.typography.titleLarge) {
                    title()
                }
            }
        }
    }

    @Composable
    fun actionsContainer() {
        Row {
            ProvideContentColor(colors.actionIconContentColor) {
                actions()
            }
        }
    }

    Header(
        attrs = modifier
            .padding(horizontal = 8.dp)
            .dom
            .gridArea("unset")
            .typeSafeClasses(BeerColorClass.PrimaryContainer)
            .height(expandedHeight.dom)
            .setVariable(Variable.appBarContainerColor, colors.containerColor.dom)
            .toAttrs()
    ) {
        if (titleHorizontalAlignment == Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    navigationContainer()
                    Spacer(modifier = Modifier.weight(1f))
                    actionsContainer()
                }
                titleContainer()
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                navigationContainer()
                titleContainer(
                    modifier = Modifier.weight(1f)
                )
                actionsContainer()
            }
        }
    }
}