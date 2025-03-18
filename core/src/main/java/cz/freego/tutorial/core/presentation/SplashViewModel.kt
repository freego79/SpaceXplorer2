package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.freego.tutorial.core.domain.GetCompanyUseCase
import cz.freego.tutorial.core.domain.GetCrewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getCompanyUseCase: GetCompanyUseCase,
    private val getCrewUseCase: GetCrewUseCase
) : ViewModel() {

    init {
        // Na pozadí spustíme načítání dat, ale na výsledek nečekáme
        // Ideálně se první data načtou do cache během splash animace
        cacheData()
    }

    private fun cacheData() {
        viewModelScope.launch {
            getCompanyUseCase(Unit)
            // Zavoláme UseCase pro načtení první stránky
            try {
                // Volání use case pro načtení první stránky
                getCrewUseCase().first() // Zavoláme bez čekání na výsledek
            } catch (e: Exception) {
                // nezajímá nás, buď dopadne nebo ne
            }
        }
    }
}
