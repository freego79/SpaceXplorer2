package cz.freego.tutorial.core.data.model

data class Height(
    val meters: Double?,
    val feet: Double?
)

data class Diameter(
    val meters: Double?,
    val feet: Double?
)

data class Thrust(
    val kN: Double?,
    val lbf: Double?
)

data class Mass(
    val kg: Int?,
    val lb: Int?
)
