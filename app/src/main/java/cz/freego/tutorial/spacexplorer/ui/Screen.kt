package cz.freego.tutorial.spacexplorer.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Splash : Screen("splash", "Splash", Icons.Filled.Home)
    object Home : Screen("home", "Home", Icons.Filled.Home)
    object SectionOverview : Screen("overview", "Přehled", Icons.Filled.Home)
    object SectionCrews : Screen("crews", "Posádky", Icons.Filled.Person)
    object SectionUnits : Screen("units", "Zařízení", Icons.Filled.Favorite)
    object SectionLaunches : Screen("launches", "Lety", Icons.Filled.Settings)
    object SectionCompany : Screen("company", "SpaceX", Icons.Filled.Info)
    object Detail : Screen("detail/{id}", "Detail", Icons.Filled.Home) {
        fun createRoute(id: Int) = "detail/$id"
    }
}