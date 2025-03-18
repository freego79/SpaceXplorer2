package cz.freego.tutorial.spacexplorer.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cz.freego.tutorial.spacexplorer.ui.Screen
import cz.freego.tutorial.spacexplorer.ui.screen.company.CompanyScreen
import cz.freego.tutorial.spacexplorer.ui.screen.crew.CrewScreen
import cz.freego.tutorial.spacexplorer.ui.screen.detail.DetailScreen
import cz.freego.tutorial.spacexplorer.ui.screen.home.HomeScreen
import cz.freego.tutorial.spacexplorer.ui.screen.overview.OverviewScreen
import cz.freego.tutorial.spacexplorer.ui.screen.section.SectionScreen
import cz.freego.tutorial.spacexplorer.ui.screen.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.Home.route) {
            val bottomNavController = rememberNavController()
            HomeScreen(bottomNavController) {
                NavHost(bottomNavController, startDestination = Screen.SectionOverview.route) {
                    composable(Screen.SectionOverview.route) { OverviewScreen(bottomNavController) }
                    composable(Screen.SectionCrews.route) { CrewScreen() }
                    composable(Screen.SectionUnits.route) { SectionScreen(bottomNavController, "Zařízení", 3) }
                    composable(Screen.SectionLaunches.route) { SectionScreen(bottomNavController, "Lety", 4) }
                    composable(Screen.SectionCompany.route) { CompanyScreen() }
                    composable(
                        route = Screen.Detail.route,
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("id") ?: 0
                        DetailScreen(id)
                    }
                }
            }
        }
    }
}