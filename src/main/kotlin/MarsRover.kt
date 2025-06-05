class MarsRover(startingPose: Pose = Pose(0, 0, Heading.NORTH)) {

    private val currentPose = startingPose

    fun getPose(): Pose = currentPose
}
