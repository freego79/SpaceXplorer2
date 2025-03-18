package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.freego.tutorial.core.domain.GetCapsuleUseCase
import cz.freego.tutorial.core.domain.GetCompanyUseCase
import cz.freego.tutorial.core.domain.GetCrewUseCase
import cz.freego.tutorial.core.domain.GetDragonUseCase
import cz.freego.tutorial.core.domain.GetRocketUseCase
import cz.freego.tutorial.core.domain.GetShipUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getCompanyUseCase: GetCompanyUseCase,
    private val getCrewUseCase: GetCrewUseCase,
    private val getRocketUseCase: GetRocketUseCase,
    private val getDragonUseCase: GetDragonUseCase,
    private val getCapsuleUseCase: GetCapsuleUseCase,
    private val getShipUseCase: GetShipUseCase,
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
                getCrewUseCase().first() // Zavoláme bez čekání na výsledek první page
                getRocketUseCase().first()
                getDragonUseCase().first()
                getCapsuleUseCase().first()
                getShipUseCase().first()
            } catch (e: Exception) {
                // nezajímá nás, buď dopadne nebo ne
            }
        }
    }
}
