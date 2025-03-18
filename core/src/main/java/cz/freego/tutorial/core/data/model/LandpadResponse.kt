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
    val images: Images?,
    val name: String?,
    @Json(name = "full_name") val fullName: String?,
    val locality: String?,
    val region: String?,
    val latitude: Double?,
    val longitude: Double?,
    @Json(name = "launch_attempts") val launchAttempts: Int?,
    @Json(name = "launch_successes") val launchSuccesses: Int?,
    val rockets: List<String>?,
    val timezone: String?,
    val launches: List<String>?,
    val status: String?,
    val details: String?,
    val id: String?
)
