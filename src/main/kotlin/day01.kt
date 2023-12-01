import java.io.File
import java.io.InputStream

fun main(){
    val inputStream: InputStream = File("src/main/kotlin/inputs/day01.txt").inputStream()
    val input = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { input.add(it) }
//    input.forEach{println(it)}

    println(star1(input))
    println(star2(input))
}

fun star1(input: List<String>): Int{
    return input
        .map { it.filter { it.isDigit() } }
        .map{ it.first().toString() + it.last()}
        .fold(0) {acc, line -> acc + line.toInt()}
}


fun star2(input: List<String>): Int {
    return input
        .map {mapNumbers(it)}
        .map{ it.filter { it.isDigit() }}
        .map{ it.first().toString() + it.last()}
        .fold(0) { acc, line -> acc + line.toInt() }
}

fun mapNumbers(s: String): String {
    return s.replace("one", "o1e")
        .replace("two", "t2o")
        .replace("three", "t3e")
        .replace("four", "4")
        .replace("five", "5e")
        .replace("six", "6")
        .replace("seven", "7")
        .replace("eight", "8t")
        .replace("nine", "9e")
}