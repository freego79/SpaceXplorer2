package cz.freego.tutorial.core.data.model

data class LaunchpadQueryRequest(
    val query: Map<String, Any?> = emptyMap(),
    val options: LaunchpadQueryOptions,
)

data class LaunchpadQueryOptions(
    val limit: Int,
    val page: Int,
)