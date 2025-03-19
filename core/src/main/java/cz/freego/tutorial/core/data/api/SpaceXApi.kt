package cz.freego.tutorial.core.data.api

import cz.freego.tutorial.core.data.model.CapsuleQueryRequest
import cz.freego.tutorial.core.data.model.CapsuleResponse
import cz.freego.tutorial.core.data.model.CompanyInfoDto
import cz.freego.tutorial.core.data.model.CrewMemberDto
import cz.freego.tutorial.core.data.model.CrewQueryRequest
import cz.freego.tutorial.core.data.model.CrewResponse
import cz.freego.tutorial.core.data.model.DragonQueryRequest
import cz.freego.tutorial.core.data.model.DragonResponse
import cz.freego.tutorial.core.data.model.LandpadQueryRequest
import cz.freego.tutorial.core.data.model.LandpadResponse
import cz.freego.tutorial.core.data.model.LaunchpadQueryRequest
import cz.freego.tutorial.core.data.model.LaunchpadResponse
import cz.freego.tutorial.core.data.model.RocketQueryRequest
import cz.freego.tutorial.core.data.model.RocketResponse
import cz.freego.tutorial.core.data.model.ShipQueryRequest
import cz.freego.tutorial.core.data.model.ShipResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SpaceXApi {
    @GET("company")
    suspend fun getCompany(): CompanyInfoDto

    @POST("crew/query")
    suspend fun queryCrews(@Body request: CrewQueryRequest): CrewResponse

    @POST("rockets/query")
    suspend fun queryRockets(@Body request: RocketQueryRequest): RocketResponse

    @POST("dragons/query")
    suspend fun queryDragons(@Body request: DragonQueryRequest): DragonResponse

    @POST("capsules/query")
    suspend fun queryCapsules(@Body request: CapsuleQueryRequest): CapsuleResponse

    @POST("ships/query")
    suspend fun queryShips(@Body request: ShipQueryRequest): ShipResponse

    @POST("launchpads/query")
    suspend fun queryLaunchpads(@Body request: LaunchpadQueryRequest): LaunchpadResponse

    @POST("landpads/query")
    suspend fun queryLandpads(@Body request: LandpadQueryRequest): LandpadResponse

    @GET("crew/{id}")
    suspend fun getCrewMember(@Path("id") id: String): CrewMemberDto
}