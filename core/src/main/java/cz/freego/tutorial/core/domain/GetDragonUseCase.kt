package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.DragonDto
import cz.freego.tutorial.core.data.repository.DragonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDragonUseCase @Inject constructor(
    private val repository: DragonRepository
) {
    operator fun invoke(): Flow<PagingData<DragonDto>> = repository.getDragon()
}
