package sk.janmokry.o2designsystem.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal val dimensions = Dimensions()

data class Dimensions(
    val radiusInput: Dp = 12.dp,
    val xs: Dp = 8.dp,
    val s: Dp = 12.dp,
    val m: Dp = 16.dp,
    val l: Dp = 20.dp,
)

/**
 * CompositionLocal used to pass [Dimensions] down the tree.
 *
 * Setting the value here is typically done as part of [O2DesignSystemTheme]. To retrieve the current
 * value of this CompositionLocal, use [O2DesignSystemTheme.d].
 */
internal val LocalDimensions = staticCompositionLocalOf { dimensions }
