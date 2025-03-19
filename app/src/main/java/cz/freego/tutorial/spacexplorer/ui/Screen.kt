package cz.freego.tutorial.spacexplorer.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String? = null, val icon: ImageVector? = null) {

    abstract fun createRoute(): String // Abstraktní metoda pro generování cesty

    object Splash : Screen("splash", "Splash", Icons.Filled.Home) {
        override fun createRoute() = route
    }

    object Home : Screen("home", "Home", Icons.Filled.Home) {
        override fun createRoute() = route
    }

    object SectionOverview : Screen("overview", "Přehled", Icons.Filled.Home) {
        override fun createRoute() = route
    }

    object SectionCrews : Screen("crews", "Posádky", Icons.Filled.Person) {
        override fun createRoute() = route
    }

    object DetailCrew : Screen("crew/{id}") {
        override fun createRoute() = createRoute("")
        fun createRoute(id: String) = "crew/$id"
    }

    object SectionUnits : Screen("units/{categoryIndex}", "Zařízení", Icons.Filled.Favorite) {
        override fun createRoute() = createRoute(0)
        fun createRoute(categoryIndex: Int) = "units/$categoryIndex"
    }

    object SectionLaunches : Screen("launches", "Lety", Icons.Filled.Settings) {
        override fun createRoute() = route
    }

    object SectionCompany : Screen("company", "SpaceX", Icons.Filled.Info) {
        override fun createRoute() = route
    }

    object Detail : Screen("detail/{id}", "Detail", Icons.Filled.Home) {
        override fun createRoute() = createRoute(0)
        fun createRoute(id: Int) = "detail/$id"
    }
}