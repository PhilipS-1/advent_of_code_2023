from functools import reduce

with open('day02.txt') as f:
    games = f.readlines()
print(games)

color_limit = {"red": 12, "green": 13, "blue": 14}
powers = []

valid_sum = 0
for game in games:
    color_min = {"red": 0, "green": 0, "blue": 0}
    game_valid = True
    game_id, subsets = game.strip().split(": ")
    game_id = int(game_id.split(" ")[-1])
    game_draws = [[word.split(" ") for word in draw.split(", ")] for draw in subsets.split("; ")]
    for game_draw in game_draws:
        for colors in game_draws:
            for color in colors:
                if color_limit[color[1]] < int(color[0]):
                    game_valid = False
                if color_min[color[1]] < int(color[0]):
                    color_min[color[1]] = int(color[0])
    power = reduce( lambda x, y: x * y, color_min.values())
    powers.append(power)
    if game_valid:                   
        valid_sum += game_id
    # print(colors)
print(valid_sum)
print(sum(powers))