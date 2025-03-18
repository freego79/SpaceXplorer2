package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.LaunchpadDto
import cz.freego.tutorial.core.domain.GetLaunchpadUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LaunchpadViewModel @Inject constructor(
    getLaunchpadUseCase: GetLaunchpadUseCase
) : ViewModel() {
    val launchpads: Flow<PagingData<LaunchpadDto>> = getLaunchpadUseCase().cachedIn(viewModelScope)
}
