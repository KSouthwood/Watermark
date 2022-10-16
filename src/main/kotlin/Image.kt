import java.awt.Transparency
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class Image(private val filename: File) {
    private val image: BufferedImage = ImageIO.read(filename)

    fun properties() {
        println("""
            Image file: $filename
            Width: ${image.width}
            Height: ${image.height}
            Number of components: ${image.colorModel.numComponents}
            Number of color components: ${image.colorModel.numColorComponents}
            Bits per pixel: ${image.colorModel.pixelSize}
            Transparency: ${transparencyMode(image.colorModel.transparency)}
        """.trimIndent())
    }

    private fun transparencyMode(mode: Int): String {
        return when(mode) {
            Transparency.OPAQUE -> "OPAQUE"
            Transparency.BITMASK -> "BITMASK"
            Transparency.TRANSLUCENT -> "TRANSLUCENT"
            else -> "Undefined"
        }
    }
}
