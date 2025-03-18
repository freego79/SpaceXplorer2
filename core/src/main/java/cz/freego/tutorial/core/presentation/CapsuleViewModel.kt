package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import cz.freego.tutorial.core.data.model.CapsuleDto
import cz.freego.tutorial.core.domain.GetCapsuleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CapsuleViewModel @Inject constructor(
    getCapsuleUseCase: GetCapsuleUseCase
) : ViewModel() {
    val capsules: Flow<PagingData<CapsuleDto>> = getCapsuleUseCase().cachedIn(viewModelScope)
}
