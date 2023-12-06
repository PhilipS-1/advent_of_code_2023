from functools import reduce

with open('day06.txt') as f:
    input = f.readlines()

# part1
times  = [int(x) for x in input[0].strip().split(" ")[1:] if x]
distances = [int(x) for x in input[1].strip().split(" ")[1:] if x]

def get_result(times, distances):
    ways_to_win = [0] * len(times)
    for i, time in enumerate(times):
        for x in range (0,time):
            if x * (time - x) > distances[i]:
                ways_to_win[i] += 1
    return ways_to_win

ways_to_win = get_result(times, distances)
result1 = reduce(lambda x, y: x * y, ways_to_win)
print(result1)

# part2
times2 = [int("".join([x for x in input[0].strip().split(" ")[1:] if x]))]
distances2 = [int("".join([x for x in input[1].strip().split(" ")[1:] if x]))]
ways_to_win2 = get_result(times2, distances2)
result2 = reduce(lambda x, y: x * y, ways_to_win2)
print(result2)
