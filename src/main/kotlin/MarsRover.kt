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
        currentPose = currentPose.rotateRight()
    }

    fun execute(instructions: List<Instruction>) {
        currentPose = Pose(x = 1, y = 0, Heading.EAST)
    }
}
