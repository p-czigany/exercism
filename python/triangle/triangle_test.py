# These tests are auto-generated with test data from:
# https://github.com/exercism/problem-specifications/tree/main/exercises/triangle/canonical-data.json
# File last updated on 2023-07-19

import unittest

from triangle import (
    equilateral,
    isosceles,
    scalene,
)


class EquilateralTriangleTest(unittest.TestCase):
    def test_all_sides_are_equal(self):
        self.assertIs(equilateral([2, 2, 2]), True)

    # @unittest.skip
    def test_any_side_is_unequal(self):
        self.assertIs(equilateral([2, 3, 2]), False)
        self.assertIs(equilateral([3, 2, 2]), False)
        self.assertIs(equilateral([2, 2, 3]), False)

    # @unittest.skip
    def test_no_sides_are_equal(self):
        self.assertIs(equilateral([5, 4, 6]), False)

    # @unittest.skip
    def test_all_zero_sides_is_not_a_triangle(self):
        self.assertIs(equilateral([0, 0, 0]), False)

    # @unittest.skip
    def test_sides_may_be_floats(self):
        self.assertIs(equilateral([0.5, 0.5, 0.5]), True)


class IsoscelesTriangleTest(unittest.TestCase):
    # @unittest.skip
    def test_last_two_sides_are_equal(self):
        self.assertIs(isosceles([3, 4, 4]), True)

    # @unittest.skip
    def test_first_two_sides_are_equal(self):
        self.assertIs(isosceles([4, 4, 3]), True)

    # @unittest.skip
    def test_first_and_last_sides_are_equal(self):
        self.assertIs(isosceles([4, 3, 4]), True)

    # @unittest.skip
    def test_equilateral_triangles_are_also_isosceles(self):
        self.assertIs(isosceles([4, 4, 4]), True)

    # @unittest.skip
    def test_no_sides_are_equal(self):
        self.assertIs(isosceles([2, 3, 4]), False)

    # @unittest.skip
    def test_first_triangle_inequality_violation(self):
        self.assertIs(isosceles([1, 1, 3]), False)

    # @unittest.skip
    def test_second_triangle_inequality_violation(self):
        self.assertIs(isosceles([1, 3, 1]), False)

    # @unittest.skip
    def test_third_triangle_inequality_violation(self):
        self.assertIs(isosceles([3, 1, 1]), False)

    # @unittest.skip
    def test_sides_may_be_floats(self):
        self.assertIs(isosceles([0.5, 0.4, 0.5]), True)


class ScaleneTriangleTest(unittest.TestCase):
    # @unittest.skip
    def test_no_sides_are_equal(self):
        self.assertIs(scalene([5, 4, 6]), True)

    # @unittest.skip
    def test_all_sides_are_equal(self):
        self.assertIs(scalene([4, 4, 4]), False)

    # @unittest.skip
    def test_first_and_second_sides_are_equal(self):
        self.assertIs(scalene([4, 4, 3]), False)

    # @unittest.skip
    def test_first_and_third_sides_are_equal(self):
        self.assertIs(scalene([3, 4, 3]), False)

    # @unittest.skip
    def test_second_and_third_sides_are_equal(self):
        self.assertIs(scalene([4, 3, 3]), False)

    # @unittest.skip
    def test_may_not_violate_triangle_inequality(self):
        self.assertIs(scalene([7, 3, 2]), False)

    # @unittest.skip
    def test_sides_may_be_floats(self):
        self.assertIs(scalene([0.5, 0.4, 0.6]), True)
