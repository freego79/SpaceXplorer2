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
    @Json(name = "last_ais_update") val lastAisUpdate: String?,
    @Json(name = "legacy_id") val legacyId: String?,
    val model: String?,
    val type: String?,
    val roles: List<String>?,
    val imo: Long?,
    val mmsi: Long?,
    val abs: Long?,
    val classField: Long?,
    @Json(name = "mass_kg") val massKg: Long?,
    @Json(name = "mass_lbs") val massLbs: Long?,
    @Json(name = "year_built") val yearBuilt: Int?,
    val homePort: String?,
    val status: String?,
    @Json(name = "speed_kn") val speedKn: Double?,
    @Json(name = "course_deg") val courseDeg: Double?,
    @Json(name = "latitude") val latitude: Double?,
    @Json(name = "longitude") val longitude: Double?,
    val link: String?,
    val image: String?,
    val name: String?,
    val active: Boolean?,
    val launches: List<String>?,
    val id: String?
)
