package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.CapsuleDto
import cz.freego.tutorial.core.domain.QueryCapsulesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CapsulesViewModel @Inject constructor(
    getCapsulesUseCase: QueryCapsulesUseCase
) : ViewModel() {
    val capsules: Flow<PagingData<CapsuleDto>> = getCapsulesUseCase().cachedIn(viewModelScope)
}
