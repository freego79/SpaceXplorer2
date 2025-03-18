package cz.freego.tutorial.core.data.model

data class CrewQueryRequest(
    val query: Map<String, String> = emptyMap(), // Prázdný objekt "query"
    val options: CrewQueryOptions // Odpovídá sekci "options"
)

data class CrewQueryOptions(
    val limit: Int,
    val page: Int
)