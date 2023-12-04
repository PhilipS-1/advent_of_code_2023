package day01

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
    return input.fold(0) { acc: Int, s: String ->
        val digits = s.filter {it.isDigit()}
        val number = digits.first().toString() + digits.last()
        acc + number.toInt()
    }
}

fun star2(input: List<String>): Int {
    val mappedInput = input.map { mapNumbers(it) }
    return star1(mappedInput)
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