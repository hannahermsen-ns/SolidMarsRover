import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class MarsRoverTest {
    @Test
    fun `When no input is given, then the robot will output its initial position and heading`() {
        // Given
        val marsRover = MarsRover()

        // When
        val pose = marsRover.getPose()

        // Then
        assertEquals(Pose(x = 0, y = 0, heading = Heading.NORTH), pose)
    }

    @Test
    fun `When a starting pose is given, the robot will output the given starting pose`() {
        // Given
        val startingPosition = Pose(x = 1, y = 1, heading = Heading.EAST)
        val marsRover = MarsRover(startingPosition)

        // When
        val pose = marsRover.getPose()

        // Then
        assertEquals(startingPosition, pose)
    }

    @ParameterizedTest
    @MethodSource("getMoveData")
    fun `When moving, the robot will move one step in the direction of the heading`(
        initialPose: Pose,
        expectedPose: Pose,
    ) {
        // Given
        val marsRover = MarsRover(initialPose)

        // When
        marsRover.move()

        // Then
        val pose = marsRover.getPose()
        assertEquals(expectedPose, pose)
    }

    @ParameterizedTest
    @MethodSource("getRotateLeftData")
    fun `When rotating left, the robot will change its heading in the correct direction`(
        initialPose: Pose,
        expectedPose: Pose,
    ) {
        // Given
        val marsRover = MarsRover(initialPose)

        // When
        marsRover.rotateLeft()

        // Then
        val pose = marsRover.getPose()
        assertEquals(expectedPose, pose)
    }

    @ParameterizedTest
    @MethodSource("getRotateRightData")
    fun `When rotating right, the robot will change its heading in the correct direction`(
        initialPose: Pose,
        expectedPose: Pose,
    ) {
        // Given
        val marsRover = MarsRover(initialPose)

        // When
        marsRover.rotateRight()

        // Then
        val pose = marsRover.getPose()
        assertEquals(expectedPose, pose)
    }

    @ParameterizedTest
    @MethodSource("getInstructionsData")
    fun `When rotating right and move forward, the robot should be in the correct pose`(
        initialPose: Pose,
        expectedPose: Pose,
        instructions: List<Instruction>,
    ) {
        // Given
        val marsRover = MarsRover(initialPose)

        // When
        marsRover.execute(instructions)

        // Then
        val actualPose = marsRover.getPose()
        assertEquals(expectedPose, actualPose)
    }

    companion object {
        @JvmStatic
        fun getInstructionsData(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    Pose(x = 0, y = 0, heading = Heading.NORTH),
                    Pose(x = 1, y = 0, heading = Heading.EAST),
                    listOf(Instruction.ROTATE_RIGHT, Instruction.MOVE),
                ),
            )

        @JvmStatic
        fun getRotateRightData(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    Pose(x = 0, y = 0, heading = Heading.NORTH),
                    Pose(x = 0, y = 0, heading = Heading.EAST),
                ),
                Arguments.of(
                    Pose(x = 0, y = 0, heading = Heading.EAST),
                    Pose(x = 0, y = 0, heading = Heading.SOUTH),
                ),
                Arguments.of(
                    Pose(x = 0, y = 0, heading = Heading.SOUTH),
                    Pose(x = 0, y = 0, heading = Heading.WEST),
                ),
                Arguments.of(
                    Pose(x = 0, y = 0, heading = Heading.WEST),
                    Pose(x = 0, y = 0, heading = Heading.NORTH),
                ),
            )

        @JvmStatic
        fun getRotateLeftData(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    Pose(x = 0, y = 0, heading = Heading.NORTH),
                    Pose(x = 0, y = 0, heading = Heading.WEST),
                ),
                Arguments.of(
                    Pose(x = 0, y = 0, heading = Heading.EAST),
                    Pose(x = 0, y = 0, heading = Heading.NORTH),
                ),
                Arguments.of(
                    Pose(x = 0, y = 0, heading = Heading.SOUTH),
                    Pose(x = 0, y = 0, heading = Heading.EAST),
                ),
                Arguments.of(
                    Pose(x = 0, y = 0, heading = Heading.WEST),
                    Pose(x = 0, y = 0, heading = Heading.SOUTH),
                ),
            )

        @JvmStatic
        fun getMoveData(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    Pose(x = 0, y = 0, heading = Heading.NORTH),
                    Pose(x = 0, y = 1, heading = Heading.NORTH),
                ),
                Arguments.of(
                    Pose(x = 0, y = 0, heading = Heading.EAST),
                    Pose(x = 1, y = 0, heading = Heading.EAST),
                ),
                Arguments.of(
                    Pose(x = 0, y = 1, heading = Heading.SOUTH),
                    Pose(x = 0, y = 0, heading = Heading.SOUTH),
                ),
                Arguments.of(
                    Pose(x = 1, y = 0, heading = Heading.WEST),
                    Pose(x = 0, y = 0, heading = Heading.WEST),
                ),
            )
    }
}
