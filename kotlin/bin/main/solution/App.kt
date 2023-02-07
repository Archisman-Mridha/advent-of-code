package solution

import java.io.File
import java.io.FileNotFoundException

fun main( ) {

    val inputFile= File("src/main/resources", "inputs.txt")

    if(!inputFile.exists( ))
        throw FileNotFoundException("inputs.txt file not found")

    inputFile.forEachLine( ) { println(it) }

}