package cz.freego.tutorial.core.design.compose.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme
import cz.freego.tutorial.core.utils.RequestState

@Composable
fun <T> LoadingLayout(
    requestState: RequestState<T>, // Stav s generickými daty
    modifier: Modifier = Modifier.fillMaxSize(),
    loadingContent: @Composable () -> Unit = { DefaultLoaidngContent() },  // Composable pro stav Loading
    errorContent: @Composable (String) -> Unit = { message -> DefaultErrorContent(message = message) }, // Composable pro stav Error s chybovou zprávou
    content: @Composable (T) -> Unit,  // Composable pro normální stav Success s daty
) {
    Box(modifier = modifier) {
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

@Preview
@Composable
private fun LoadingLayout_LoadingPreview() {
    SpaceXplorerTheme {
        Surface {
            LoadingLayout(
                requestState = RequestState.Loading,
            ) {}
        }
    }
}

@Preview
@Composable
private fun LoadingLayout_ErrorPreview() {
    SpaceXplorerTheme {
        Surface {
            LoadingLayout(
                requestState = RequestState.Error(message = "Něco se pokazilo!"),
            ) {}
        }
    }
}

@Preview
@Composable
private fun LoadingLayout_SuccessPreview() {
    val requestState = RequestState.Success(data = "Success Data")
    SpaceXplorerTheme {
        Surface {
            LoadingLayout(
                requestState = requestState,

                ) {
                Text(requestState.data)
            }
        }
    }
}