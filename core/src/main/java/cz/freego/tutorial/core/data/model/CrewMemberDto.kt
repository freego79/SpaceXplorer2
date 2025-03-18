package cz.freego.tutorial.core.data.model

data class CrewMemberDto(
    val id: String,
    val name: String,
    val agency: String,
    val image: String,
    val wikipedia: String,
    val status: String,
    val launches: List<String>
)
