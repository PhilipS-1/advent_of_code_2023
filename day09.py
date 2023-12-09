with open("day09.txt", 'r') as file:
    lines = file.readlines()

histories = [[int(x) for x in history.strip().split(" ")] for history in lines]

#part1
def lists_to_append(acc, sequence):
    diff_sequence = [j - i for (i, j) in zip(sequence, sequence[1:]) ] 
    if all(x == 0 for x in diff_sequence):
        acc.append(diff_sequence)
        return acc
    acc.append(diff_sequence)
    return lists_to_append(acc, diff_sequence)

result = []
for history in histories:
    sequences = lists_to_append([history], history)
    next_elements = [0]
    for i, sequence in enumerate(sequences[::-1]):
        if i != 0:
            next_elements.append(sequence[-1] + next_elements[i-1])
    result.append(next_elements[-1])
print(sum(result))

#part2
result2 = []
for history in histories:
    sequences = lists_to_append([history], history)
    prev_elements = [0]
    for i, sequence in enumerate(sequences[::-1]):
        if i != 0:
            prev_elements.append(sequence[0] - prev_elements[i-1])
    result2.append(prev_elements[-1])
print(sum(result2))
