package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.domain.GetCrewUseCase
import cz.freego.tutorial.core.domain.GetRocketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    getCrewUseCase: GetCrewUseCase,
    getRocketUseCase: GetRocketUseCase,
) : ViewModel() {
    val crewMembers: Flow<PagingData<CrewMemberDto>> = getCrewUseCase().cachedIn(viewModelScope)
    val rockets: Flow<PagingData<RocketDto>> = getRocketUseCase().cachedIn(viewModelScope)
}
