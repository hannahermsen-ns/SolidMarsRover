import org.junit.jupiter.api.Test
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
}
