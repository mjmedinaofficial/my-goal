package com.example.mygoal.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = NotesAmber,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFF1CC),
    onPrimaryContainer = Color(0xFF3D2E00),
    secondary = SecondaryLabel,
    onSecondary = Color.White,
    background = GroupedBackgroundLight,
    onBackground = LabelLight,
    surface = CardLight,
    onSurface = LabelLight,
    surfaceVariant = SeparatorLight,
    onSurfaceVariant = SecondaryLabel,
    surfaceTint = Color.Transparent,
    surfaceContainerLowest = CardLight,
    surfaceContainerLow = CardLight,
    surfaceContainer = CardLight,
    surfaceContainerHigh = CardLight,
    surfaceContainerHighest = SeparatorLight,
    inverseSurface = Color(0xFF2C2C2E),
    inverseOnSurface = Color.White,
    inversePrimary = NotesAmberDark,
    outline = OutlineLight,
    outlineVariant = SeparatorLight,
    error = DestructiveLight,
)

private val DarkColors = darkColorScheme(
    primary = NotesAmberDark,
    onPrimary = Color.Black,
    primaryContainer = Color(0xFF4A3D00),
    onPrimaryContainer = NotesAmberDark,
    secondary = SecondaryLabel,
    onSecondary = Color.Black,
    background = GroupedBackgroundDark,
    onBackground = LabelDark,
    surface = CardDark,
    onSurface = LabelDark,
    surfaceVariant = CardDarkElevated,
    onSurfaceVariant = SecondaryLabel,
    surfaceTint = Color.Transparent,
    surfaceContainerLowest = GroupedBackgroundDark,
    surfaceContainerLow = CardDark,
    surfaceContainer = CardDark,
    surfaceContainerHigh = CardDarkElevated,
    surfaceContainerHighest = Color(0xFF3A3A3C),
    inverseSurface = Color(0xFFE5E5EA),
    inverseOnSurface = Color.Black,
    inversePrimary = NotesAmber,
    outline = OutlineDark,
    outlineVariant = SeparatorDark,
    error = DestructiveDark,
)

/** Colours Material 3 doesn't name: sheet backgrounds and their grouped rows, like iOS. */
@Immutable
data class AppColors(
    val sheetBackground: Color,
    val sheetCard: Color,
    val separator: Color,
    val destructive: Color,
)

private val LightAppColors = AppColors(GroupedBackgroundLight, CardLight, SeparatorLight, DestructiveLight)
private val DarkAppColors = AppColors(CardDark, CardDarkElevated, SeparatorDark, DestructiveDark)

val LocalAppColors = staticCompositionLocalOf { LightAppColors }

@Composable
fun MyGoalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    // Dynamic colour is intentionally off: the app keeps its own calm, Notes-like identity.
    CompositionLocalProvider(LocalAppColors provides if (darkTheme) DarkAppColors else LightAppColors) {
        MaterialTheme(
            colorScheme = if (darkTheme) DarkColors else LightColors,
            typography = Typography,
            content = content,
        )
    }
}
