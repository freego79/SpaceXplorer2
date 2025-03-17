package cz.freego.tutorial.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.freego.tutorial.core.data.model.CompanyInfoDto
import cz.freego.tutorial.core.domain.GetCompanyUseCase
import cz.freego.tutorial.core.utils.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(
    private val getCompanyUseCase: GetCompanyUseCase
) : ViewModel() {

    private val _companyInfo = MutableStateFlow<RequestState<CompanyInfoDto>>(RequestState.Idle)
    val companyInfo: StateFlow<RequestState<CompanyInfoDto>> get() = _companyInfo

    init {
        fetchCompanyInfo()
    }

    fun fetchCompanyInfo() {
        _companyInfo.value = RequestState.Loading
        viewModelScope.launch {
            _companyInfo.value = getCompanyUseCase(Unit)
        }
    }
}