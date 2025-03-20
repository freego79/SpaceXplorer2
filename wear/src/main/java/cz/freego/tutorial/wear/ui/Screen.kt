package cz.freego.tutorial.wear.ui

sealed class Screen(val route: String) {

    abstract fun createRoute(): String // Abstraktní metoda pro generování cesty

    object Splash : Screen("splash") {
        override fun createRoute() = route
    }

    object Home : Screen("home") {
        override fun createRoute() = route
    }

    object DetailCrew : Screen("crew/{id}") {
        override fun createRoute() = createRoute("")
        fun createRoute(id: String) = "crew/$id"
    }
}