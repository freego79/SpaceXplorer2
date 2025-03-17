package cz.freego.tutorial.spacexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme
import cz.freego.tutorial.spacexplorer.ui.screen.AppNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // Tato anotace umožňuje Hiltu provádět DI do Activity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpaceXplorerTheme {
                AppNavigation()
            }
        }
    }
}
