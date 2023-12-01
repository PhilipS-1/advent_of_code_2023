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
    return input.map { it.filter { it.isDigit() } }
        .map{ it.first().toString() + it.last()}
        .fold(0) {acc, line -> acc + line.toInt()}
}

fun star2(input: List<String>): Int{
    return input.map {findFirstNumber(it).toString() + findLastNumber(it)}
        .fold(0) {acc, line -> acc + line.toInt()}
}

fun findFirstNumber(s: String): Char =
    when {
        s.first().isDigit() -> s.first()
        s.startsWith("one") -> '1'
        s.startsWith("two") -> '2'
        s.startsWith(("three")) -> '3'
        s.startsWith("four") ->  '4'
        s.startsWith("five") ->  '5'
        s.startsWith("six") ->  '6'
        s.startsWith("seven") ->  '7'
        s.startsWith("eight") ->  '8'
        s.startsWith("nine") ->  '9'
        else -> findFirstNumber(s.drop(1))
    }

fun findLastNumber(s: String): Char =
    when {
        s.last().isDigit() -> s.last()
        s.endsWith("one") -> '1'
        s.endsWith("two") -> '2'
        s.endsWith(("three")) -> '3'
        s.endsWith("four") ->  '4'
        s.endsWith("five") ->  '5'
        s.endsWith("six") ->  '6'
        s.endsWith("seven") ->  '7'
        s.endsWith("eight") ->  '8'
        s.endsWith("nine") ->  '9'
        else -> findLastNumber(s.dropLast(1))
    }

