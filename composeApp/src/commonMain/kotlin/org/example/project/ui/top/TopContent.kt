package org.example.project.ui.top

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.Portrait
import androidx.compose.material.icons.rounded.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import org.example.project.data.UiConfig
import org.example.project.ui.component.BodyMediumText
import org.example.project.ui.component.HeadlineLargeText
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.img_profile_icon

@Composable
fun TopContent(
    toProfile: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(UiConfig.LargePadding),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(UiConfig.SmallPadding),
            ) {
                Image(
                    modifier = Modifier.size(UiConfig.MediumIconSize).clip(CircleShape),
                    painter = painterResource(Res.drawable.img_profile_icon),
                    contentDescription = "Profile Icon",
                    contentScale = ContentScale.Crop,
                )
                Column {
                    HeadlineLargeText(
                        text = "けい",
                    )
                    BodyMediumText(
                        text = "Android Developer",
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(UiConfig.ExtraLargePadding),
            ) {
                TopButton(
                    onClick = toProfile,
                    icon = Icons.Rounded.Portrait,
                    title = "Profile",
                )
                TopButton(
                    onClick = { },
                    icon = Icons.Rounded.Work,
                    title = "Works",
                )
                TopButton(
                    onClick = { },
                    icon = Icons.Rounded.AccountCircle,
                    title = "SNS",
                )
                TopButton(
                    onClick = { },
                    icon = Icons.Rounded.Description,
                    title = "Blog",
                )
            }
        }
    }
}

@Composable
fun TopButton(
    onClick: () -> Unit,
    icon: ImageVector,
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(UiConfig.ExtraSmallPadding),
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.background(
                MaterialTheme.colorScheme.surfaceVariant,
                CircleShape,
            ),
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(UiConfig.SmallIconSize)
                    .padding(UiConfig.ExtraSmallPadding),
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }
        BodyMediumText(
            text = title,
        )
    }
}
