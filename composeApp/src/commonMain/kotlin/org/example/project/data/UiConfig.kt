package org.example.project.data

import androidx.compose.ui.unit.dp

@Suppress("MagicNumber")
data object UiConfig {
    // Icon sizes
    val ExtraLargeIconSize = 200.dp
    val LargeIconSize = 150.dp
    val MediumIconSize = 100.dp
    val SmallIconSize = 75.dp

    // Padding values
    val ContentPadding = 70.dp
    val ExtraLargePadding = 40.dp
    val LargePadding = 30.dp
    val MediumPadding = 20.dp
    val SmallPadding = 10.dp
    val ExtraSmallPadding = 5.dp

    // Weight
    const val DefaultWeight = 1f

    // Mobile Width
    val MobileWidth = 600.dp

    // Splash Screen
    const val SplashLoadingAnimationRotation = 25f

    // Profile Screen
    val ProfileCareerThickness = 5.dp
    val ProfileCareerDividerWidth = 15.dp
}
