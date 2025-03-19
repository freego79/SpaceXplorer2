package cz.freego.tutorial.core.domain

import cz.freego.tutorial.core.data.model.CompanyInfoDto
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.data.repository.GetCompanyRepository
import cz.freego.tutorial.core.data.repository.GetCrewRepository
import cz.freego.tutorial.core.utils.RequestState
import javax.inject.Inject

class GetCrewUseCase @Inject constructor(
    private val repository: GetCrewRepository
) : UseCase<String, RequestState<CrewMemberDto>> {
    override suspend fun invoke(id: String): RequestState<CrewMemberDto> {
        return repository.getCrew(id)
    }
}
