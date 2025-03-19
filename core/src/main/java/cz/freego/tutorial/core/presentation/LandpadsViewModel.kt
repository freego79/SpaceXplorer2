package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.LandpadDto
import cz.freego.tutorial.core.domain.QueryLandpadsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LandpadsViewModel @Inject constructor(
    getLandpadsUseCase: QueryLandpadsUseCase
) : ViewModel() {
    val landpads: Flow<PagingData<LandpadDto>> = getLandpadsUseCase().cachedIn(viewModelScope)
}
