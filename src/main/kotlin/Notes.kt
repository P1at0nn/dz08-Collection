data class Notes(
    val note_id: Int,
    val comments: Comments,
    val message: String ="null",
    val remoteDel:Boolean = false
) {
}