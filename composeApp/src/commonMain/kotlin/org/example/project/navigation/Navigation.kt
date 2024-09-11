package org.example.project.navigation

interface Navigation {
    fun getCurrentPath(): String

    fun navigateTo(path: String)

    fun addOnHashChangeListener(listener: () -> Unit)
}

expect fun provideNavigation(): Navigation
