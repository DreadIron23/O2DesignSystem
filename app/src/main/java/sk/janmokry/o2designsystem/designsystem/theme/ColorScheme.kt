package sk.janmokry.o2designsystem.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val colorScheme = ColorScheme()

@Immutable
data class ColorScheme(
    val surfaceXHigh: Color = gray500,
    val surfaceXLow: Color = gray00,
    val surfaceBrand: Color = blue500,
    val surfaceDanger: Color = red600,
    val surfaceDangerVariant: Color = red100,
    val surfaceWarning: Color = yellow700,
    val surfaceWarningVariant: Color = yellow100,
    val contentOnNeutralXxHigh: Color = gray950,
    val contentOnNeutralMedium: Color = gray500,
    val contentOnNeutralLow: Color = gray300,
    val contentOnNeutralDanger: Color = red600,
    val contentOnNeutralWarning: Color = red700,
    val stateDefaultHover: Color = alphaDim50,
    val stateDefaultFocus: Color = alphaDim800,
)

/**
 * CompositionLocal used to pass [ColorScheme] down the tree.
 *
 * Setting the value here is typically done as part of [O2DesignSystemTheme]. To retrieve the current
 * value of this CompositionLocal, use [O2DesignSystemTheme.colorScheme].
 */
internal val LocalColorScheme = staticCompositionLocalOf { colorScheme }
