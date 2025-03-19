package cz.freego.tutorial.spacexplorer.ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import cz.freego.tutorial.spacexplorer.Constants
import cz.freego.tutorial.spacexplorer.ui.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    content: @Composable () -> Unit,
    ) {
    val sectionsScreens = listOf(
        Screen.SectionOverview,
        Screen.SectionCrews,
        Screen.SectionUnits,
        Screen.SectionLaunches,
        Screen.SectionCompany,
    )

    val otherScreens = listOf(
        Screen.Detail,
    )

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination
    val currentScreen = sectionsScreens.find { screen ->
        currentDestination?.route?.startsWith(screen.route) == true
    } ?: otherScreens.find { screen ->
        currentDestination?.route?.startsWith(screen.route.substringBefore("/{")) == true
    }

    var selectedItem by rememberSaveable { mutableIntStateOf(0) }

    val currentRoute = currentBackStackEntry?.destination?.route
    val sectionIndex = sectionsScreens.indexOfFirst { it.route == currentRoute }
    if (sectionIndex > -1) selectedItem = sectionIndex

    var isBottomNavigationBarHidden by rememberSaveable {
        mutableStateOf(true)
    }
    isBottomNavigationBarHidden = sectionIndex < 0 && Constants.HIDE_BOTTOM_NAVIGATION

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(currentScreen?.title ?: "") },
                navigationIcon = {
                    if (currentRoute != Screen.SectionOverview.route) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
//                actions = {
//                    if (currentRoute == Screen.Section1.route) {
//                        IconButton(onClick = { /* Nějaká akce */ }) {
//                            Icon(Icons.Default.Settings, contentDescription = "Settings")
//                        }
//                    }
//                }
            )
        },

        bottomBar = {
            AnimatedVisibility(
                visible = !isBottomNavigationBarHidden,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                NavigationBar {
                    sectionsScreens.forEachIndexed { index, screen ->
                        NavigationBarItem(
                            selected = index == selectedItem,
                            onClick = {
                                navController.popBackStack(navController.graph.startDestinationId, false)
                                navController.navigate(screen.createRoute()) {
                                    popUpTo(Screen.Home.route) { saveState = true } // zachová stav při návratu
                                    launchSingleTop = true // zabrání zbytečnému znovuvytváření obrazovek
                                    restoreState = true // zachová stav obrazovky při návratu
                                }
                            },
                            icon = { Icon(screen.icon, contentDescription = screen.title) },
                            label = { Text(text = screen.title, maxLines = 1, overflow = TextOverflow.Ellipsis) }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            content()
        }
    }
}