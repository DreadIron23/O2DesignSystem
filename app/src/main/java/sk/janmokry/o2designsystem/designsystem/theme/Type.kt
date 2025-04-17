package sk.janmokry.o2designsystem.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import sk.janmokry.o2designsystem.R

internal val typography = Typography()

private val InterFontFamily =
    FontFamily(
        Font(resId = R.font.inter_variable)
    )

data class Typography(
    val labelM: TextStyle = TextStyle(
        fontFamily = InterFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 22.sp,
        letterSpacing = 0.16.sp,
    ),
    val labelS: TextStyle = TextStyle(
        fontFamily = InterFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight(550),
        lineHeight = 17.sp,
        letterSpacing = 0.16.sp,
    ),
    val bodyM: TextStyle = TextStyle(
        fontFamily = InterFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 22.sp,
        letterSpacing = 0.01.sp,
    ),
)

internal val LocalTypography = staticCompositionLocalOf { typography }
