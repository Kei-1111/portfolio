package org.example.project.ui.profile

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.StarRate
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.example.project.data.AnimationConfig
import org.example.project.data.SkillSet
import org.example.project.data.UiConfig
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun SkillsSection(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        SectionTitle(
            title = "スキル",
        )

        SectionContent(
            modifier = Modifier.fillMaxWidth(),
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(UiConfig.LargePadding),
                ) {
                    SkillSet.ratedSkills.forEach { skill ->
                        RatedSkill(
                            modifier = Modifier.fillMaxWidth(),
                            skillIcon = skill.image,
                            rate = skill.rating,
                        )
                    }
                }
            },
        )
    }
}

@Composable
fun RatedSkill(
    skillIcon: DrawableResource,
    rate: Int,
    modifier: Modifier = Modifier,
) {
    val infiniteTransition = rememberInfiniteTransition()

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SkillIcon(
            skillIcon = skillIcon,
        )
        Spacer(modifier = Modifier.padding(UiConfig.SmallPadding))
        for (i in SkillSet.MinRating..SkillSet.MaxRating) {
            val alpha by infiniteTransition.animateFloat(
                initialValue = AnimationConfig.ProfileRatedInitialAlpha,
                targetValue = AnimationConfig.ProfileRatedFinalAlpha,
                animationSpec = infiniteRepeatable(
                    animation = tween(AnimationConfig.ProfileRatedDuration),
                    repeatMode = RepeatMode.Reverse,
                    initialStartOffset = StartOffset(i * AnimationConfig.ProfileRatedInitialStartOffset),
                ),
            )

            Icon(
                imageVector = Icons.Rounded.StarRate,
                contentDescription = "Skill Icon",
                modifier = Modifier.size(UiConfig.SmallIconSize),
                tint = if (i <= rate) {
                    MaterialTheme.colorScheme.inversePrimary.copy(
                        alpha = alpha,
                    )
                } else {
                    MaterialTheme.colorScheme.surfaceContainerHigh
                },
            )
        }
    }
}

@Composable
fun SkillIcon(
    skillIcon: DrawableResource,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(skillIcon),
        contentDescription = null,
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surfaceContainerHighest,
                MaterialTheme.shapes.small,
            )
            .size(UiConfig.SmallIconSize)
            .padding(UiConfig.SmallPadding),
    )
}
