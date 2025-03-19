package cz.freego.tutorial.core.domain

import cz.freego.tutorial.core.data.model.CompanyInfoDto
import cz.freego.tutorial.core.data.repository.GetCompanyRepository
import cz.freego.tutorial.core.utils.RequestState
import javax.inject.Inject

class GetCompanyUseCase @Inject constructor(
    private val repository: GetCompanyRepository
) : UseCase<Unit, RequestState<CompanyInfoDto>> {
    override suspend fun invoke(input: Unit): RequestState<CompanyInfoDto> {
        return repository.getCompanyInfo()
    }
}
