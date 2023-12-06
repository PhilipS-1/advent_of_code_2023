package day05
import java.io.File

fun main() {
    val input = File("src/main/kotlin/inputs/day05.txt").readText()
    val maps = input.split("\r\n\r\n")
//    prLongln(maps[1].drop(1))
//    input.forEach { prLongln(it) }
    
    println(star1(maps))
//    prLongln(star2(input))
}

fun star1(input: List<String>){
//    val seeds = input.take(1)
    val split_maps = input.map{it.lines()}
    val seeds = split_maps[0].flatMap{it.split(" ")}.drop(1).map{it.toLong()}
    val real_maps = split_maps.drop(1)
        .map{
            it.drop(1).map{
                it.split(" ").filter{it != ""}.map{it.toLong()}
            }
        }
    println(real_maps.last.dropLast(1))
    val real_real_maps = real_maps.dropLast(1).map{make_mapping(it)}
    println(real_real_maps[0])
    val mapped = mapSeeds(seeds, real_real_maps)
    println()
    println(mapped)
}

fun make_mapping(list: List<List<Long>>):List<Pair<Pair<Long, Long>, Pair<Long, Long>>>{
    return list.map{
        val destStart = it[0]
        val sourceStart = it[1]
        val range = it[2]
        Pair(
            Pair(sourceStart, sourceStart + range -1) , Pair(destStart, destStart + range -1)
        )
    }.sortedBy{it.first.first}
}

//return lowest location no.
fun mapSeeds(seeds: List<Long>, mapping: List<List<Pair<Pair<Long, Long>, Pair<Long, Long>>>>): Long{
    val mapped = seeds.map{
        findMapping(it, mapping)
    }
    println(mapped)
    return mapped.minBy{it}
}

fun findMapping(n: Long, mapping: List<List<Pair<Pair<Long, Long>, Pair<Long, Long>>>>): Long{
    return applyForward(n, mapping)
}

fun forward(n: Long, mapping: List<Pair<Pair<Long, Long>, Pair<Long, Long>>>): Long{
//    if (n < mapping[0].first.first) return n
//    else if (n > mapping.last.first.second) return n
    for (map in mapping) {
        val diff = n - map.first.first
        if ((n <= map.first.second) && (diff  >= 0) ) return map.second.first + diff
    }
    return n
}

fun applyForward(n: Long, mapping: List<List<Pair<Pair<Long, Long>, Pair<Long, Long>>>> ): Long{
    if (mapping.isEmpty()) return n
    val mappedN = forward(n, mapping[0])
    return applyForward(mappedN, mapping.drop(1))
}