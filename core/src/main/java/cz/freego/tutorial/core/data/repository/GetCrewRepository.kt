package cz.freego.tutorial.core.data.repository

import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.utils.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCrewRepository(private val api: SpaceXApi) {
    suspend fun getCrew(id: String): RequestState<CrewMemberDto> {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getCrewMember(id)
                RequestState.Success(response)
            }
        } catch (e: Exception) {
            RequestState.Error(e.localizedMessage ?: "Unknown error")
        }
    }
}