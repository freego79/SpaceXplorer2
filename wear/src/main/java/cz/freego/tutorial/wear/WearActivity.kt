package cz.freego.tutorial.wear

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme
import cz.freego.tutorial.wear.ui.AppNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WearActivity : ComponentActivity() {
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
