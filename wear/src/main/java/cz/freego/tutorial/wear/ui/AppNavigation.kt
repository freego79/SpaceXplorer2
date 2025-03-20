package cz.freego.tutorial.wear.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cz.freego.tutorial.wear.ui.screen.crew.CrewDetailScreen
import cz.freego.tutorial.wear.ui.screen.home.HomeScreen
import cz.freego.tutorial.wear.ui.screen.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(navController) }

        composable(Screen.Home.route) { HomeScreen(navController) }

        composable(
            route = Screen.DetailCrew.route,
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            CrewDetailScreen(id = id)
        }
    }
}