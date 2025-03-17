package cz.freego.tutorial.core.data.api

import cz.freego.tutorial.core.data.model.CompanyInfoDto
import retrofit2.http.GET

interface SpaceXApi {
    @GET("company")
    suspend fun getCompanyInfo(): CompanyInfoDto
}