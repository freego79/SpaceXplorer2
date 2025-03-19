package cz.freego.tutorial.core.data.model

data class Height(
    val meters: Double? = null,
    val feet: Double? = null
)

data class Diameter(
    val meters: Double? = null,
    val feet: Double? = null
)

data class Thrust(
    val kN: Double? = null,
    val lbf: Double? = null
)

data class Mass(
    val kg: Int? = null,
    val lb: Int? = null
)

data class Images(
    val large: List<String>? = null
)
