class MarsRover(
    startingPose: Pose = Pose(0, 0, Heading.NORTH),
) {
    private var currentPose = startingPose

    fun getPose(): Pose = currentPose

    fun move() {
        currentPose = currentPose.moved()
    }

    fun rotateLeft() {
        currentPose = currentPose.rotateLeft()
    }

    fun rotateRight() {
        rotateLeft()
        rotateLeft()
        rotateLeft()
    }
}
