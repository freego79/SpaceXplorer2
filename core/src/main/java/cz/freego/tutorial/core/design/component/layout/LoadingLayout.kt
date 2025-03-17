package cz.freego.tutorial.core.design.component.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.freego.tutorial.core.utils.RequestState

@Composable
fun <T> LoadingLayout(
    requestState: RequestState<T>, // Stav s generickými daty
    modifier: Modifier = Modifier.fillMaxSize(),
    paddingValues: PaddingValues = PaddingValues(horizontal = 16.dp),
    loadingContent: @Composable () -> Unit = { DefaultLoaidngContent() },  // Composable pro stav Loading
    errorContent: @Composable (String) -> Unit = { message -> DefaultErrorContent(message = message) }, // Composable pro stav Error s chybovou zprávou
    content: @Composable (T) -> Unit,  // Composable pro normální stav Success s daty
) {
    Column(
        modifier = modifier.padding(paddingValues)
    ) {
        when (requestState) {
            is RequestState.Loading -> {
                // Zobrazíme obsah pro stav "Loading"
                loadingContent()
            }
            is RequestState.Error -> {
                // Zobrazíme obsah pro stav "Error"
                errorContent(requestState.message)
            }
            is RequestState.Success -> {
                // Předáme data do "content" pro stav "Success"
                content(requestState.data)
            }
            else -> {
                // Pokud je stav Idle, není třeba nic vykreslovat
            }
        }
    }
}
