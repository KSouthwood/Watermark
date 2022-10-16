import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import uk.org.webcompere.systemstubs.jupiter.SystemStub
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension
import uk.org.webcompere.systemstubs.stream.SystemIn
import uk.org.webcompere.systemstubs.stream.SystemOut
import java.io.File

@ExtendWith(SystemStubsExtension::class)
internal class WatermarkTest {
    @SystemStub
    private var systemIn: SystemIn = SystemIn()

    @SystemStub
    private val systemOut: SystemOut = SystemOut()

    @Test
    fun `test image file with alpha channel`() {
        systemOut.clear()
        Image(File("src/stage1/rgbaImage.png")).properties()
        assertEquals("""
            Image file: src/stage1/rgbaImage.png
            Width: 101
            Height: 51
            Number of components: 4
            Number of color components: 3
            Bits per pixel: 32
            Transparency: TRANSLUCENT
            
            """.trimIndent(),
            systemOut.linesNormalized)
    }

    @Test
    fun `test image file without alpha channel`() {
        systemOut.clear()
        Image(File("src/stage1/rgbImage.png")).properties()
        assertEquals("""
            Image file: src/stage1/rgbImage.png
            Width: 101
            Height: 51
            Number of components: 3
            Number of color components: 3
            Bits per pixel: 24
            Transparency: OPAQUE
            
            """.trimIndent(),
            systemOut.linesNormalized)
    }
}
