package cz.freego.tutorial.core.design.theme.phone

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    background = ColorsLight.background,
    surface = ColorsLight.surface,
    primary = ColorsLight.primary,
    secondary = ColorsLight.secondary,
    tertiary = ColorsLight.tertiary,
    onPrimary = ColorsLight.onPrimary,
    //onSecondary = ColorsLight.onSecondary,
    //onTertiary = ColorsLight.onTertiary,
    onBackground = ColorsLight.onBackground,
    onSurface = ColorsLight.onSurface,
    surfaceContainer = ColorsLight.surfaceContainer,
)

private val DarkColorScheme = darkColorScheme(
    background = ColorsDark.background,
    surface = ColorsDark.surface,
    primary = ColorsDark.primary,
    secondary = ColorsDark.secondary,
    tertiary = ColorsDark.tertiary,
    onPrimary = ColorsDark.onPrimary,
    //onSecondary = ColorsDark.onSecondary,
    //onTertiary = ColorsDark.onTertiary,
    onBackground = ColorsDark.onBackground,
    onSurface = ColorsDark.onSurface,
    surfaceContainer = ColorsDark.surfaceContainer,
)

@Composable
fun SpaceXplorerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}