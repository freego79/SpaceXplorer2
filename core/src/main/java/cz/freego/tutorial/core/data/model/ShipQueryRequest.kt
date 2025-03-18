package cz.freego.tutorial.core.data.model

data class ShipQueryRequest(
    val query: Map<String, Any?> = emptyMap(),
    val options: ShipQueryOptions,
)

data class ShipQueryOptions(
    val limit: Int,
    val page: Int,
)