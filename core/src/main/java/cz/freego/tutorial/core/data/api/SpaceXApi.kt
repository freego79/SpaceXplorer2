package cz.freego.tutorial.core.data.api

import cz.freego.tutorial.core.data.model.CompanyInfoDto
import cz.freego.tutorial.core.data.model.CrewQueryRequest
import cz.freego.tutorial.core.data.model.CrewResponse
import cz.freego.tutorial.core.data.model.RocketQueryRequest
import cz.freego.tutorial.core.data.model.RocketResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SpaceXApi {
    @GET("company")
    suspend fun getCompanyInfo(): CompanyInfoDto

    @POST("crew/query")
    suspend fun queryCrew(@Body request: CrewQueryRequest): CrewResponse

    @POST("rockets/query")
    suspend fun queryRocket(@Body request: RocketQueryRequest): RocketResponse

}