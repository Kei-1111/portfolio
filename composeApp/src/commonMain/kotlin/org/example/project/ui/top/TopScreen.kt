package org.example.project.ui.top

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Suppress("ModifierMissing")
@Composable
fun TopScreen(
    toProfile: () -> Unit,
) {
    TopContent(
        toProfile = toProfile,
        modifier = Modifier.fillMaxSize(),
    )
}
