package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.data.model.DragonDto
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.data.model.ShipDto
import cz.freego.tutorial.core.domain.QueryCrewsUseCase
import cz.freego.tutorial.core.domain.QueryDragonsUseCase
import cz.freego.tutorial.core.domain.QueryRocketsUseCase
import cz.freego.tutorial.core.domain.QueryShipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    getCrewUseCase: QueryCrewsUseCase,
    getDragonUseCase: QueryDragonsUseCase,
    getRocketUseCase: QueryRocketsUseCase,
    getShipUseCase: QueryShipsUseCase,
) : ViewModel() {
    val crewMembers: Flow<PagingData<CrewMemberDto>> = getCrewUseCase().cachedIn(viewModelScope)
    val dragons: Flow<PagingData<DragonDto>> = getDragonUseCase().cachedIn(viewModelScope)
    val rockets: Flow<PagingData<RocketDto>> = getRocketUseCase().cachedIn(viewModelScope)
    val ships: Flow<PagingData<ShipDto>> = getShipUseCase().cachedIn(viewModelScope)
}
