package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.freego.tutorial.core.domain.GetCapsuleUseCase
import cz.freego.tutorial.core.domain.GetCompanyUseCase
import cz.freego.tutorial.core.domain.GetCrewUseCase
import cz.freego.tutorial.core.domain.GetDragonUseCase
import cz.freego.tutorial.core.domain.GetLandpadUseCase
import cz.freego.tutorial.core.domain.GetLaunchpadUseCase
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
    private val getLaunchpadUseCase: GetLaunchpadUseCase,
    private val getLandpadUseCase: GetLandpadUseCase,
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
            // Zavoláme bez čekání na výsledek první page
            try { getCrewUseCase().first() } catch (_: Exception) {}
            try { getRocketUseCase().first() } catch (_: Exception) {}
            try { getDragonUseCase().first() } catch (_: Exception) {}
            try { getCapsuleUseCase().first() } catch (_: Exception) {}
            try { getShipUseCase().first() } catch (_: Exception) {}
            try { getLaunchpadUseCase().first() } catch (_: Exception) {}
            try { getLandpadUseCase().first() } catch (_: Exception) {}
        }
    }
}
