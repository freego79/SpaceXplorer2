package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.CapsuleDto
import cz.freego.tutorial.core.data.repository.CapsuleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCapsuleUseCase @Inject constructor(
    private val repository: CapsuleRepository
) {
    operator fun invoke(): Flow<PagingData<CapsuleDto>> = repository.getCapsule()
}
