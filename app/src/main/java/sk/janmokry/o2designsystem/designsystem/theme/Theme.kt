package sk.janmokry.o2designsystem.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun O2DesignSystemTheme(
    colorScheme: ColorScheme = O2DesignSystemTheme.colorScheme,
    typography: Typography = O2DesignSystemTheme.typography,
    dimensions: Dimensions = O2DesignSystemTheme.dimensions,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
        LocalTypography provides typography,
        LocalDimensions provides dimensions,
        content = content,
    )
}

/**
 * Contains functions to access the current theme values provided at the call site's position in the
 * hierarchy.
 */
object O2DesignSystemTheme {
    /**
     * Retrieves the current [ColorScheme] at the call site's position in the hierarchy.
     */
    val colorScheme: ColorScheme
        @Composable @ReadOnlyComposable get() = LocalColorScheme.current

    /**
     * Retrieves the current [Typography] at the call site's position in the hierarchy.
     */
    val typography: Typography
        @Composable @ReadOnlyComposable get() = LocalTypography.current

    /**
     * Retrieves the current [Dimensions] at the call site's position in the hierarchy.
     */
    val dimensions: Dimensions
        @Composable @ReadOnlyComposable get() = LocalDimensions.current
}
