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
}
