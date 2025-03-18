package cz.freego.tutorial.core.data.model

data class DragonQueryRequest(
    val query: Map<String, Any?> = emptyMap(),
    val options: DragonQueryOptions,
)

data class DragonQueryOptions(
    val limit: Int,
    val page: Int,
)