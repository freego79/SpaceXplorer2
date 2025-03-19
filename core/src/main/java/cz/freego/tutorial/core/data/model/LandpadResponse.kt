package cz.freego.tutorial.core.data.model

import com.squareup.moshi.Json

data class LandpadResponse(
    val docs: List<LandpadDto>,
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

data class LandpadDto(
    val images: Images? = null,
    val name: String? = null,
    @Json(name = "full_name") val fullName: String? = null,
    val locality: String? = null,
    val region: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    @Json(name = "launch_attempts") val launchAttempts: Int? = null,
    @Json(name = "launch_successes") val launchSuccesses: Int? = null,
    val rockets: List<String>? = null,
    val timezone: String? = null,
    val launches: List<String>? = null,
    val status: String? = null,
    val details: String? = null,
    val id: String? = null
)
