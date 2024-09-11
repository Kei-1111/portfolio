package org.example.project.ui.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.example.project.data.UiConfig
import org.example.project.ui.component.HeadlineLargeText
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.img_profile_icon

@Composable
fun SplashContent(
    s: String,
    profileIconAlphaAnimation: Animatable<Float, AnimationVector1D>,
    profileIconXOffsetAnimation: Animatable<Float, AnimationVector1D>,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.alpha(profileIconAlphaAnimation.value),
        ) {
            Image(
                painter = painterResource(Res.drawable.img_profile_icon),
                contentDescription = "Profile icon",
                modifier = Modifier
                    .offset(x = profileIconXOffsetAnimation.value.dp) // スライドインの位置指定
                    .size(UiConfig.MediumIconSize)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
            if (s != "") {
                Spacer(
                    modifier = Modifier
                        .padding(UiConfig.SmallPadding),
                )
            }
            HeadlineLargeText(
                text = s,
            )
        }
    }
}
