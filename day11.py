from itertools import combinations

with open('day11.txt', 'r') as f:
    input = f.readlines()

input = [x.strip() for x in input]

empty_row = [x for x, line in enumerate(input) if set(line) == {"."}]
empty_col = [x for x, line in enumerate(zip(*input)) if set(line) == {"."}]


coords = []
for x, line in enumerate(input):
    for y, val in enumerate(line):
        if val != ".":
            coords.append((x,y))


def calc_result(factor):
    sum = 0
    for i, ((x1, y1), (x2, y2)) in enumerate(combinations(coords, 2)):
        lx, hx = sorted([x1, x2])
        ly, hy = sorted([y1, y2])
        no_empty_rows = len([row for row in empty_row if row < hx and row > lx])
        no_empty_col = len([col for col in empty_col if col < hy and col > ly])
        manhattan = abs(x1 - x2) + abs(y1 - y2) 
        sum += manhattan + (factor - 1) * no_empty_rows +  (factor-1) * no_empty_col
    return sum

print(calc_result(2))
print(calc_result(1000000))

