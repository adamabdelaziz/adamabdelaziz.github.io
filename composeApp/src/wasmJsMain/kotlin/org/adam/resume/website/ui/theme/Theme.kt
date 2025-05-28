package org.adam.resume.website.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    colors: AppColors = DarkPopAppColors,
    shapes: AppShapes = AppShapes(),
    typography: AppTypography = AppTypography(),
    dimensions: AppDimensions = ExpandedDimensions,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppShapes provides shapes,
        LocalAppTypography provides  typography,
        LocalAppDimensions provides dimensions
    ) {
        content()
    }
}