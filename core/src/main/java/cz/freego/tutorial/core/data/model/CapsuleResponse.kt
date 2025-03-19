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
    @Json(name = "reuse_count") val reuseCount: Int? = null,
    @Json(name = "water_landings") val waterLandings: Int? = null,
    @Json(name = "land_landings") val landLandings: Int? = null,
    @Json(name = "last_update") val lastUpdate: String? = null,
    val launches: List<String>? = null,
    val serial: String? = null,
    val status: String? = null,
    val type: String? = null,
    val id: String? = null
)
