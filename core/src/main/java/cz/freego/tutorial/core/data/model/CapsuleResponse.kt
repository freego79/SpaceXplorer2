package cz.freego.tutorial.core.data.model

import com.squareup.moshi.Json

data class CapsuleResponse(
    val docs: List<CapsuleDto>,
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

data class CapsuleDto(
    @Json(name = "reuse_count") val reuseCount: Int?,
    @Json(name = "water_landings") val waterLandings: Int?,
    @Json(name = "land_landings") val landLandings: Int?,
    @Json(name = "last_update") val lastUpdate: String?,
    val launches: List<String>?,
    val serial: String?,
    val status: String?,
    val type: String?,
    val id: String?
)
