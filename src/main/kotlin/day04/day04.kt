package day04

import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("src/main/kotlin/inputs/day04.txt").inputStream()
    val input = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { input.add(it) }
//    input.forEach { println(it) }
    println(star1(input))
    println(star2(input))
}

fun star1(input: List<String>): Int{
            return input.fold(0){acc: Int, line: String ->
                val nums = line.split("|")
                val winNums = nums[0].split(" ").filter{s -> s != ""}.drop(2).map{ s -> s.toInt()}
                val myNums = nums[1].split(" ").filter{s -> s != ""}.map{s -> s.toInt()}
                val count = myNums.filter{n -> n in winNums}.size
                val points = if (count == 0)  0 else if  (count == 1) 1 else (1..count).toList().reduce{b, _ -> b * 2}
                acc + points
            }
    }


fun star2(input: List<String>): Int{
    println(1..3)
    val cards = List(input.size){1}.toMutableList()
    input.forEachIndexed { i, line: String ->
        val nums = line.split("|")
        val winNums = nums[0].split(" ").filter { s -> s != "" }.drop(2).map { s -> s.toInt() }
        val myNums = nums[1].split(" ").filter { s -> s != "" }.map { s -> s.toInt() }
        val count = myNums.filter { n -> n in winNums }.size
        if (count != 0) {
            val range =  (i + 1)..(i + count)
            range.forEach{
                cards[it] += cards[i]
            }
        }
    }
    return cards.sum()
}
