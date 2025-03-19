package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.domain.QueryCapsulesUseCase
import cz.freego.tutorial.core.domain.GetCompanyUseCase
import cz.freego.tutorial.core.domain.QueryCrewsUseCase
import cz.freego.tutorial.core.domain.QueryDragonsUseCase
import cz.freego.tutorial.core.domain.QueryLandpadsUseCase
import cz.freego.tutorial.core.domain.QueryLaunchpadsUseCase
import cz.freego.tutorial.core.domain.QueryRocketsUseCase
import cz.freego.tutorial.core.domain.QueryShipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getCompanyUseCase: GetCompanyUseCase,
    private val getCrewsUseCase: QueryCrewsUseCase,
    private val getRocketsUseCase: QueryRocketsUseCase,
    private val getDragonsUseCase: QueryDragonsUseCase,
    private val getCapsulesUseCase: QueryCapsulesUseCase,
    private val getShipsUseCase: QueryShipsUseCase,
    private val getLaunchpadsUseCase: QueryLaunchpadsUseCase,
    private val getLandpadsUseCase: QueryLandpadsUseCase,
) : ViewModel() {

    init {
        // Na pozadí spustíme načítání dat, ale na výsledek nečekáme
        // Ideálně se první data načtou do cache během splash animace
        if (Constants.PRECACHE_ON_SPLASHSCREEN) cacheData()
    }

    private fun cacheData() {
        viewModelScope.launch {
            getCompanyUseCase(Unit)
            // Zavoláme UseCase pro načtení první stránky
            // Zavoláme bez čekání na výsledek první page
            try { getCrewsUseCase().first() } catch (_: Exception) {}
            try { getRocketsUseCase().first() } catch (_: Exception) {}
            try { getDragonsUseCase().first() } catch (_: Exception) {}
            try { getCapsulesUseCase().first() } catch (_: Exception) {}
            try { getShipsUseCase().first() } catch (_: Exception) {}
            try { getLaunchpadsUseCase().first() } catch (_: Exception) {}
            try { getLandpadsUseCase().first() } catch (_: Exception) {}
        }
    }
}
