package cz.freego.tutorial.spacexplorer.ui.screen.company

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cz.freego.tutorial.core.presentation.CompanyViewModel
import cz.freego.tutorial.core.utils.RequestState
import androidx.hilt.navigation.compose.hiltViewModel
import cz.freego.tutorial.core.design.component.layout.DefaultErrorContent
import cz.freego.tutorial.core.design.component.layout.LoadingLayout

@Composable
fun CompanyScreen(
    viewModel: CompanyViewModel = hiltViewModel()
) {
    val companyState by viewModel.companyInfo.collectAsState()

//    LaunchedEffect(Unit) {
//        viewModel.fetchCompanyInfo()
//    }

    LoadingLayout(
        requestState = companyState,
        errorContent = {
            DefaultErrorContent(
                message = (companyState as RequestState.Error).message,
                onRetry = { viewModel.fetchCompanyInfo() },
            )
        }
    ) { data ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text("Název společnosti: ${data.name}")
            Text("Zakladet: ${data.founder}")
        }
    }
}