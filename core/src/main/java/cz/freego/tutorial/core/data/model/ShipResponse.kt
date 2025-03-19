package cz.freego.tutorial.core.data.model

import com.squareup.moshi.Json

data class ShipResponse(
    val docs: List<ShipDto>,
    val totalDocs: Int?,
    val limit: Int?,
    val totalPages: Int?,
    val page: Int?,
    val pagingCounter: Int?,
    val hasPrevPage: Boolean,
    val hasNextPage: Boolean,
    val prevPage: Int?,
    val nextPage: Int?
)

data class ShipDto(
    @Json(name = "last_ais_update") val lastAisUpdate: String? = null,
    @Json(name = "legacy_id") val legacyId: String? = null,
    val model: String? = null,
    val type: String? = null,
    val roles: List<String>? = null,
    val imo: Long? = null,
    val mmsi: Long? = null,
    val abs: Long? = null,
    val classField: Long? = null,
    @Json(name = "mass_kg") val massKg: Long? = null,
    @Json(name = "mass_lbs") val massLbs: Long? = null,
    @Json(name = "year_built") val yearBuilt: Int? = null,
    val homePort: String? = null,
    val status: String? = null,
    @Json(name = "speed_kn") val speedKn: Double? = null,
    @Json(name = "course_deg") val courseDeg: Double? = null,
    @Json(name = "latitude") val latitude: Double? = null,
    @Json(name = "longitude") val longitude: Double? = null,
    val link: String? = null,
    val image: String? = null,
    val name: String? = null,
    val active: Boolean? = null,
    val launches: List<String>? = null,
    val id: String? = null
)
