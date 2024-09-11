package org.example.project.navigation

sealed class Screens(val route: String) {
    data object Profile : Screens(route = "profile")
}
