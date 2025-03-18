package cz.freego.tutorial.core.data.model

import com.squareup.moshi.Json

data class CompanyInfoDto(
    val name: String?,
    val founder: String?,
    val founded: Int?,
    val employees: Int?,
    val vehicles: Int?,
    @Json(name = "launch_sites") val launchSites: Int?,
    @Json(name = "test_sites") val testSites: Int?,
    val ceo: String?,
    val cto: String?,
    val coo: String?,
    @Json(name = "cto_propulsion") val ctoPropulsion: String?,
    val valuation: Long?,
    val summary: String?,
    val headquarters: Headquarters?,
    val links: Links?,
)

data class Headquarters(
    val address: String?,
    val city: String?,
    val state: String?,
)

data class Links(
    val website: String?,
    val flickr: String?,
    val twitter: String?,
    @Json(name = "elon_twitter") val elonTwitter: String?,
)
