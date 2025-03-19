package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.ShipDto
import cz.freego.tutorial.core.domain.QueryShipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ShipsViewModel @Inject constructor(
    getShipsUseCase: QueryShipsUseCase
) : ViewModel() {
    val ships: Flow<PagingData<ShipDto>> = getShipsUseCase().cachedIn(viewModelScope)
}
