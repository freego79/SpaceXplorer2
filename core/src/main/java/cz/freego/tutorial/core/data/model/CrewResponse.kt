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
    val id: String?,
    val name: String?,
    val agency: String?,
    val image: String?,
    val wikipedia: String?,
    val status: String?,
    val launches: List<String>?,
)