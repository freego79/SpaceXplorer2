package cz.freego.tutorial.core.domain

import androidx.paging.PagingData
import cz.freego.tutorial.core.data.model.ShipDto
import cz.freego.tutorial.core.data.repository.QueryShipsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QueryShipsUseCase @Inject constructor(
    private val repository: QueryShipsRepository
) {
    operator fun invoke(): Flow<PagingData<ShipDto>> = repository.getShips()
}
