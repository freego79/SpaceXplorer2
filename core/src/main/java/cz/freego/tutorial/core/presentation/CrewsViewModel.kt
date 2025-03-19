package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.domain.QueryCrewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CrewsViewModel @Inject constructor(
    getCrewsUseCase: QueryCrewsUseCase
) : ViewModel() {
    val crewMembers: Flow<PagingData<CrewMemberDto>> = getCrewsUseCase().cachedIn(viewModelScope)
}
