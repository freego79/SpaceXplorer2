package cz.freego.tutorial.core.data.model

import com.squareup.moshi.Json

data class DragonResponse(
    val docs: List<DragonDto>,
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

data class DragonDto(
    @Json(name = "heat_shield") val heatShield: HeatShield? = null,
    @Json(name = "launch_payload_mass") val launchPayloadMass: Mass? = null,
    @Json(name = "launch_payload_vol") val launchPayloadVol: Volume? = null,
    @Json(name = "return_payload_mass") val returnPayloadMass: Mass? = null,
    @Json(name = "return_payload_vol") val returnPayloadVol: Volume? = null,
    @Json(name = "pressurized_capsule") val pressurizedCapsule: PressurizedCapsule? = null,
    val trunk: Trunk? = null,
    @Json(name = "height_w_trunk") val heightWTrunk: Height? = null,
    val diameter: Diameter? = null,
    @Json(name = "first_flight") val firstFlight: String? = null,
    @Json(name = "flickr_images") val flickrImages: List<String>? = null,
    val name: String? = null,
    val type: String? = null,
    val active: Boolean? = null,
    @Json(name = "crew_capacity") val crewCapacity: Int? = null,
    @Json(name = "sidewall_angle_deg") val sidewallAngleDeg: Int? = null,
    @Json(name = "orbit_duration_yr") val orbitDurationYr: Int? = null,
    @Json(name = "dry_mass_kg") val dryMassKg: Int? = null,
    @Json(name = "dry_mass_lb") val dryMassLb: Int? = null,
    val thrusters: List<Thruster>? = null,
    val wikipedia: String? = null,
    val description: String? = null,
    val id: String? = null
)

data class HeatShield(
    val material: String? = null,
    @Json(name = "size_meters") val sizeMeters: Double? = null,
    @Json(name = "temp_degrees") val tempDegrees: Double? = null,
    @Json(name = "dev_partner") val devPartner: String? = null,
)

data class Volume(
    @Json(name = "cubic_meters") val cubicMeters: Int? = null,
    @Json(name = "cubic_feet") val cubicFeet: Int? = null,
)

data class PressurizedCapsule(
    @Json(name = "payload_volume") val payloadVolume: Volume? = null,
)

data class Trunk(
    @Json(name = "trunk_volume") val trunkVolume: Volume? = null,
    val cargo: Cargo? = null
)

data class Cargo(
    @Json(name = "solar_array") val solarArray: Int? = null,
    @Json(name = "unpressurized_cargo") val unpressurizedCargo: Boolean? = null,
)

data class Thruster(
    val type: String? = null,
    val amount: Int? = null,
    val pods: Int? = null,
    @Json(name = "fuel_1") val fuel1: String? = null,
    @Json(name = "fuel_2") val fuel2: String? = null,
    val isp: Int? = null,
    val thrust: Thrust? = null
)
