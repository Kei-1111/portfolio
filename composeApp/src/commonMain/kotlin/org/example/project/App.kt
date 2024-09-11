package org.example.project

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.project.ui.profile.ProfileScreen
import org.example.project.ui.theme.AppTheme

@Suppress("ModifierMissing")
@Composable
fun App() {
    AppTheme(
        darkTheme = false,
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface,
        ) {
            ProfileScreen()
        }
    }
}

enum class DeviceType {
    Mobile, Desktop
}
