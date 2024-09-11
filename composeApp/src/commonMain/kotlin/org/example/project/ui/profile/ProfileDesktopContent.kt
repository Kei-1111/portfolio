package org.example.project.ui.profile

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import org.example.project.data.AnimationConfig
import org.example.project.data.UiConfig
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.img_profile_icon

@Composable
fun ProfileDesktopContent(
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val animatedSize by animateDpAsState(
        targetValue = if (isHovered) UiConfig.ExtraLargeIconSize else UiConfig.LargeIconSize,
        animationSpec = tween(durationMillis = AnimationConfig.ShortDuration),
    )

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surface,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(UiConfig.ContentPadding),
            ) {
                ProfileHeader(
                    modifier = Modifier.fillMaxWidth(),
                    profileIcon = Res.drawable.img_profile_icon,
                    name = "けい",
                )

                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(
                            start = UiConfig.ContentPadding,
                            top = UiConfig.MediumPadding,
                            end = UiConfig.ContentPadding,
                        ),
                ) {
                    CareerSection(
                        modifier = Modifier.weight(UiConfig.DefaultWeight),
                    )

                    Column(
                        modifier = Modifier.weight(UiConfig.ProfileDesktopRightWeight),
                    ) {
                        SkillsSection()
                        Spacer(modifier = Modifier.weight(UiConfig.DefaultWeight))
                        ToolsSection()
                    }
                }
            }
        }
        WorksIcon(
            animatedSize = animatedSize,
            circleColor = MaterialTheme.colorScheme.inversePrimary,
            interactionSource = interactionSource,
        )
    }
}
