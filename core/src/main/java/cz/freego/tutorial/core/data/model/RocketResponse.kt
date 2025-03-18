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
    val id: String?,
    val name: String?,
    val height: Height?,
    val diameter: Diameter?,
    val mass: Mass?,
    @Json(name = "first_stage") val firstStage: Stage?,
    @Json(name = "second_stage") val secondStage: Stage?,
    val engines: Engine?,
    @Json(name = "landing_legs") val landingLegs: LandingLegs?,
    @Json(name = "payload_weights") val payloadWeights: List<PayloadWeight>?,
    @Json(name = "flickr_images") val flickrImages: List<String>?,
    val type: String?,
    val active: Boolean?,
    val stages: Int?,
    val boosters: Int?,
    @Json(name = "cost_per_launch") val costPerLaunch: Int?,
    @Json(name = "success_rate_pct") val successRatePct: Int?,
    @Json(name = "first_flight") val firstFlight: String?,
    val country: String?,
    val company: String?,
    val wikipedia: String?,
    val description: String?,
)

data class Stage(
    @Json(name = "thrust_sea_level") val thrustSeaLevel: Thrust?,
    @Json(name = "thrust_vacuum") val thrustVacuum: Thrust?,
    val reusable: Boolean?,
    val engines: Int?,
    @Json(name = "fuel_amount_tons") val fuelAmountTons: Double?,
    @Json(name = "burn_time_sec") val burnTimeSec: Int?,
)

data class Engine(
    val isp: ISP?,
    @Json(name = "thrust_sea_level") val thrustSeaLevel: Thrust?,
    @Json(name = "thrust_vacuum") val thrustVacuum: Thrust?,
    val number: Int?,
    val type: String?,
    val version: String?,
)
data class ISP(
    @Json(name = "sea_level") val seaLevel: Int?,
    val vacuum: Int?,
)
data class LandingLegs(val number: Int?, val material: String?)
data class PayloadWeight(val id: String?, val name: String?, val kg: Int?, val lb: Int?)
