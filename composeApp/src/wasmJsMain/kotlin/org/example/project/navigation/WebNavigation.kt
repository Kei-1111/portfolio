package org.example.project.navigation

import kotlinx.browser.window

class WebNavigation : Navigation {
    override fun getCurrentPath(): String {
        return window.location.hash.removePrefix("#")
    }

    override fun navigateTo(path: String) {
        window.location.hash = "#$path"
    }

    override fun addOnHashChangeListener(listener: () -> Unit) {
        window.onhashchange = { listener() }
    }
}

actual fun provideNavigation(): Navigation = WebNavigation()
