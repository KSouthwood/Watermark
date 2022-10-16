import java.io.File

fun main(args: Array<String>) {
    println("Input the image filename:")
    val image = File(readln())
    if (image.exists()) {
        Image(image).properties()
    } else {
        println("The file ${image.name} doesn't exist.")
    }
}
