package cz.freego.tutorial.core.data.model

data class CrewResponse(
    val docs: List<CrewMemberDto>,
    val totalDocs: Int?,
    val limit: Int?,
    val totalPages: Int?,
    val page: Int?,
    val pagingCounter: Int?,
    val hasPrevPage: Boolean,
    val hasNextPage: Boolean,
    val prevPage: Int?,
    val nextPage: Int?,
)

data class CrewMemberDto(
    val id: String? = null,
    val name: String? = null,
    val agency: String? = null,
    val image: String? = null,
    val wikipedia: String? = null,
    val status: String? = null,
    val launches: List<String>? = null,
)
