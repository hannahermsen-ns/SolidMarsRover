class MarsRover(
    startingPose: Pose = Pose(0, 0, Heading.NORTH),
) {
    private var currentPose = startingPose

    fun getPose(): Pose = currentPose

    fun move() {
        currentPose = when (currentPose.heading) {
            Heading.NORTH -> currentPose.copy(y = currentPose.y + 1)
            Heading.EAST -> currentPose.copy(x = currentPose.x + 1)
        }
    }
}
