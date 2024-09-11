package org.example.project

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.example.project.navigation.Screens.Profile
import org.example.project.navigation.provideNavigation
import org.example.project.ui.profile.ProfileScreen
import org.example.project.ui.splash.SplashScreen
import org.example.project.ui.theme.AppTheme

@OptIn(ExperimentalAnimationApi::class)
@Suppress("ModifierMissing")
@Composable
fun App() {
    val navController = provideNavigation()
    var currentPath by remember { mutableStateOf(navController.getCurrentPath()) }

    LaunchedEffect(Unit) {
        navController.addOnHashChangeListener {
            currentPath = navController.getCurrentPath()
        }
    }

    AppTheme(
        darkTheme = false,
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface,
        ) {
            AnimatedContent(targetState = currentPath, transitionSpec = {
                (fadeIn(tween(2000)) + scaleIn(
                    initialScale = 0.5f, animationSpec = tween(1000)
                )).togetherWith(
                        fadeOut(tween(1000)) + scaleOut(
                            targetScale = 0f, animationSpec = tween(500)
                        )
                    )
            }) { targetPath ->
                when (targetPath) {
                    Profile.route -> ProfileScreen()

                    else -> SplashScreen(toProfile = {
                        navController.navigateTo(Profile.route)
                    })
                }
            }
        }
    }
}

enum class DeviceType {
    Mobile, Desktop
}
