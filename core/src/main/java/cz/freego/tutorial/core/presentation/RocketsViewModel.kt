package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.domain.QueryRocketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RocketsViewModel @Inject constructor(
    getRocketsUseCase: QueryRocketsUseCase
) : ViewModel() {
    val rockets: Flow<PagingData<RocketDto>> = getRocketsUseCase().cachedIn(viewModelScope)
}
