package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.DragonDto
import cz.freego.tutorial.core.domain.QueryDragonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DragonsViewModel @Inject constructor(
    getDragonsUseCase: QueryDragonsUseCase
) : ViewModel() {
    val dragons: Flow<PagingData<DragonDto>> = getDragonsUseCase().cachedIn(viewModelScope)
}
