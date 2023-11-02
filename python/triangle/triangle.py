SET_FOR_NUMBER_OF_EQUAL_SIDES = {1: 3, 2: 2, 3: 1}


def equilateral(sides):
    return is_triangle(sides) and equal_sides(3, sides)


def is_triangle(sides):
    return all(side > 0 for side in sides) and longest_side_is_shorter_than_the_sum_of_the_others(sides)


def longest_side_is_shorter_than_the_sum_of_the_others(sides):
    sides.sort()
    return sides[2] < sides[0] + sides[1]


def equal_sides(number_of_equal_sides, sides):
    return len(set(sides)) == SET_FOR_NUMBER_OF_EQUAL_SIDES.get(number_of_equal_sides)


def isosceles(sides):
    return is_triangle(sides) and (equal_sides(2, sides) or equal_sides(3, sides))


def scalene(sides):
    return is_triangle(sides) and equal_sides(1, sides)
