package cz.freego.tutorial.core.data.model

import com.squareup.moshi.Json

data class RocketResponse(
    val docs: List<RocketDto>,
    val totalDocs: Int?,
    val limit: Int?,
    val totalPages: Int?,
    val page: Int?,
    val pagingCounter: Int?,
    val hasPrevPage: Boolean,
    val hasNextPage: Boolean,
    val prevPage: Int?,
    val nextPage: Int?,
)

data class RocketDto(
    val id: String? = null,
    val name: String? = null,
    val height: Height? = null,
    val diameter: Diameter? = null,
    val mass: Mass? = null,
    @Json(name = "first_stage") val firstStage: Stage? = null,
    @Json(name = "second_stage") val secondStage: Stage? = null,
    val engines: Engine? = null,
    @Json(name = "landing_legs") val landingLegs: LandingLegs? = null,
    @Json(name = "payload_weights") val payloadWeights: List<PayloadWeight>? = null,
    @Json(name = "flickr_images") val flickrImages: List<String>? = null,
    val type: String? = null,
    val active: Boolean? = null,
    val stages: Int? = null,
    val boosters: Int? = null,
    @Json(name = "cost_per_launch") val costPerLaunch: Int? = null,
    @Json(name = "success_rate_pct") val successRatePct: Int? = null,
    @Json(name = "first_flight") val firstFlight: String? = null,
    val country: String? = null,
    val company: String? = null,
    val wikipedia: String? = null,
    val description: String? = null
)

data class Stage(
    @Json(name = "thrust_sea_level") val thrustSeaLevel: Thrust? = null,
    @Json(name = "thrust_vacuum") val thrustVacuum: Thrust? = null,
    val reusable: Boolean? = null,
    val engines: Int? = null,
    @Json(name = "fuel_amount_tons") val fuelAmountTons: Double? = null,
    @Json(name = "burn_time_sec") val burnTimeSec: Int? = null
)

data class Engine(
    val isp: ISP? = null,
    @Json(name = "thrust_sea_level") val thrustSeaLevel: Thrust? = null,
    @Json(name = "thrust_vacuum") val thrustVacuum: Thrust? = null,
    val number: Int? = null,
    val type: String? = null,
    val version: String? = null
)

data class ISP(
    @Json(name = "sea_level") val seaLevel: Int? = null,
    val vacuum: Int? = null
)

data class LandingLegs(
    val number: Int? = null,
    val material: String? = null
)

data class PayloadWeight(
    val id: String? = null,
    val name: String? = null,
    val kg: Int? = null,
    val lb: Int? = null
)
