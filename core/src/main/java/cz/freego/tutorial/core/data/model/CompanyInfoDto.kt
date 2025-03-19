package cz.freego.tutorial.core.data.model

import com.squareup.moshi.Json

data class CompanyInfoDto(
    val name: String? = null,
    val founder: String? = null,
    val founded: Int? = null,
    val employees: Int? = null,
    val vehicles: Int? = null,
    @Json(name = "launch_sites") val launchSites: Int? = null,
    @Json(name = "test_sites") val testSites: Int? = null,
    val ceo: String? = null,
    val cto: String? = null,
    val coo: String? = null,
    @Json(name = "cto_propulsion") val ctoPropulsion: String? = null,
    val valuation: Long? = null,
    val summary: String? = null,
    val headquarters: Headquarters? = null,
    val links: Links? = null,
)

data class Headquarters(
    val address: String? = null,
    val city: String? = null,
    val state: String? = null,
)

data class Links(
    val website: String? = null,
    val flickr: String? = null,
    val twitter: String? = null,
    @Json(name = "elon_twitter") val elonTwitter: String? = null,
)
