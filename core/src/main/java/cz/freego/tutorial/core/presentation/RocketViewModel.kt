package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.RocketDto
import cz.freego.tutorial.core.domain.GetRocketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RocketViewModel @Inject constructor(
    getRocketUseCase: GetRocketUseCase
) : ViewModel() {
    val rockets: Flow<PagingData<RocketDto>> = getRocketUseCase().cachedIn(viewModelScope)
}
