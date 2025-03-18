package cz.freego.tutorial.core.data.model

data class RocketQueryRequest(
    val query: Map<String, String> = emptyMap(), // Prázdný objekt "query"
    val options: RocketQueryOptions
)

data class RocketQueryOptions(
    val limit: Int,
    val page: Int
)
