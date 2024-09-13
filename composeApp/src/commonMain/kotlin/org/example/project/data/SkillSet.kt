package org.example.project.data

import org.jetbrains.compose.resources.DrawableResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.img_compose_multiplatform
import portfolio.composeapp.generated.resources.img_github
import portfolio.composeapp.generated.resources.img_jetpack_compose
import portfolio.composeapp.generated.resources.img_kotlin

data object SkillSet {
    const val MaxRating = 5
    const val MinRating = 1

    val ratedSkills = listOf(
        Skill(
            image = Res.drawable.img_kotlin,
            name = "Kotlin",
            rating = 4,
        ),
        Skill(
            image = Res.drawable.img_jetpack_compose,
            name = "Jetpack Compose",
            rating = 3,
        ),
        Skill(
            image = Res.drawable.img_compose_multiplatform,
            name = "Compose Multiplatform",
            rating = 2,
        ),
        Skill(
            image = Res.drawable.img_github,
            name = "GitHub",
            rating = 2,
        ),
    )
}

data class Skill(
    val image: DrawableResource,
    val name: String,
    val rating: Int,
)
