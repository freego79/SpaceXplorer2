package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.LaunchpadDto
import cz.freego.tutorial.core.domain.QueryLaunchpadsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LaunchpadsViewModel @Inject constructor(
    getLaunchpadsUseCase: QueryLaunchpadsUseCase
) : ViewModel() {
    val launchpads: Flow<PagingData<LaunchpadDto>> = getLaunchpadsUseCase().cachedIn(viewModelScope)
}
