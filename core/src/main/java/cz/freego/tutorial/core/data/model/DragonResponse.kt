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
    @Json(name = "heat_shield") val heatShield: HeatShield?,
    @Json(name = "launch_payload_mass") val launchPayloadMass: Mass?,
    @Json(name = "launch_payload_vol") val launchPayloadVol: Volume?,
    @Json(name = "return_payload_mass") val returnPayloadMass: Mass?,
    @Json(name = "return_payload_vol") val returnPayloadVol: Volume?,
    @Json(name = "pressurized_capsule") val pressurizedCapsule: PressurizedCapsule?,
    val trunk: Trunk?,
    @Json(name = "height_w_trunk") val heightWTrunk: Height?,
    val diameter: Diameter?,
    @Json(name = "first_flight") val firstFlight: String?,
    @Json(name = "flickr_images") val flickrImages: List<String>?,
    val name: String?,
    val type: String?,
    val active: Boolean?,
    @Json(name = "crew_capacity") val crewCapacity: Int?,
    @Json(name = "sidewall_angle_deg") val sidewallAngleDeg: Int?,
    @Json(name = "orbit_duration_yr") val orbitDurationYr: Int?,
    @Json(name = "dry_mass_kg") val dryMassKg: Int?,
    @Json(name = "dry_mass_lb") val dryMassLb: Int?,
    val thrusters: List<Thruster>?,
    val wikipedia: String?,
    val description: String?,
    val id: String?
)

data class HeatShield(
    val material: String?,
    @Json(name = "size_meters") val sizeMeters: Double?,
    @Json(name = "temp_degrees") val tempDegrees: Double?,
    @Json(name = "dev_partner") val devPartner: String?,
)

data class Volume(
    @Json(name = "cubic_meters") val cubicMeters: Int?,
    @Json(name = "cubic_feet") val cubicFeet: Int?,
)

data class PressurizedCapsule(
    @Json(name = "payload_volume") val payloadVolume: Volume?,
)

data class Trunk(
    @Json(name = "trunk_volume") val trunkVolume: Volume?,
    val cargo: Cargo?
)

data class Cargo(
    @Json(name = "solar_array") val solarArray: Int?,
    @Json(name = "unpressurized_cargo") val unpressurizedCargo: Boolean?,
)

data class Thruster(
    val type: String?,
    val amount: Int?,
    val pods: Int?,
    @Json(name = "fuel_1") val fuel1: String?,
    @Json(name = "fuel_2") val fuel2: String?,
    val isp: Int?,
    val thrust: Thrust?
)
