package cz.freego.tutorial.core.data.repository

import cz.freego.tutorial.core.Constants
import cz.freego.tutorial.core.data.api.SpaceXApi
import cz.freego.tutorial.core.data.model.CompanyInfoDto
import cz.freego.tutorial.core.utils.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random

class GetCompanyRepository(private val api: SpaceXApi) {
    suspend fun getCompanyInfo(): RequestState<CompanyInfoDto> {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getCompany()
                if (Constants.SIMULATED_ERRORS && Random.nextBoolean()) {
                    throw Exception("Uměle simulovaná chyba!")
                }
                RequestState.Success(response)
            }
        } catch (e: Exception) {
            RequestState.Error(e.localizedMessage ?: "Unknown error")
        }
    }
}