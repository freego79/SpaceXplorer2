package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.domain.GetCrewUseCase
import cz.freego.tutorial.core.utils.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CrewViewModel @Inject constructor(
    private val getCrewUseCase: GetCrewUseCase
) : ViewModel() {

    private val _crew = MutableStateFlow<RequestState<CrewMemberDto>>(RequestState.Idle)
    val crew: StateFlow<RequestState<CrewMemberDto>> get() = _crew

    fun fetchCrew(id: String) {
        _crew.value = RequestState.Loading
        viewModelScope.launch {
            _crew.value = getCrewUseCase(id)
        }
    }
}