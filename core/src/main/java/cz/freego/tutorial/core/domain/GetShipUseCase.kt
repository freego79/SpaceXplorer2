package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.ShipDto
import cz.freego.tutorial.core.data.repository.ShipRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetShipUseCase @Inject constructor(
    private val repository: ShipRepository
) {
    operator fun invoke(): Flow<PagingData<ShipDto>> = repository.getShip()
}
