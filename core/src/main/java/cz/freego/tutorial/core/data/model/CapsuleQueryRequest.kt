package cz.freego.tutorial.core.data.model

data class CapsuleQueryRequest(
    val query: Map<String, Any?> = emptyMap(),
    val options: CapsuleQueryOptions,
)

data class CapsuleQueryOptions(
    val limit: Int,
    val page: Int,
)