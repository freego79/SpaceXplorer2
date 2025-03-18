package cz.freego.tutorial.core.data.model

data class LandpadQueryRequest(
    val query: Map<String, Any?> = emptyMap(),
    val options: LandpadQueryOptions,
)

data class LandpadQueryOptions(
    val limit: Int,
    val page: Int,
)