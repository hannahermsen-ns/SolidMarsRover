data class Pose(
    private val x: Int,
    private val y: Int,
    private val heading: Heading,
) {

    fun moved(): Pose {
        return when (heading) {
            Heading.NORTH -> copy(y = y + 1)
            Heading.EAST -> copy(x = x + 1)
        }
    }
}
