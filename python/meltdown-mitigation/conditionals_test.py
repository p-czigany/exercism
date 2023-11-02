import unittest

import pytest

from conditionals import (is_criticality_balanced,
                          reactor_efficiency,
                          efficiency_ratio,
                          fail_safe,
                          fail_safe_ratio,
                          efficiency_color_code,
                          fail_safe_code)


class MeltdownMitigationTest(unittest.TestCase):
    """Test cases for Meltdown mitigation exercise.
    """

    # @unittest.skip
    @pytest.mark.task(taskno=1)
    def test_is_criticality_balanced(self):
        """Testing border cases around typical points.

        T, n == (800, 500), (625, 800), (500, 1000), etc.

        """

        test_data = ((750, 650, True), (799, 501, True), (500, 600, True),
                     (1000, 800, False), (800, 500, False), (800, 500.01, False),
                     (799.99, 500, False), (500.01, 999.99, False), (625, 800, False),
                     (625.99, 800, False), (625.01, 799.99, False), (799.99, 500.01, True),
                     (624.99, 799.99, True), (500, 1000, False), (500.01, 1000, False),
                     (499.99, 1000, True))

        for variant, data in enumerate(test_data, start=1):
            temp, neutrons_emitted, expected = data
            with self.subTest(f'variation #{variant}', temp=temp, neutrons_emitted=neutrons_emitted, expected=expected):
                # pylint: disable=assignment-from-no-return
                actual_result = is_criticality_balanced(temp, neutrons_emitted)
                failure_message = (f'Expected {expected} but returned {actual_result} '
                                   f'with T={temp} and neutrons={neutrons_emitted}')
                self.assertEqual(expected, actual_result, failure_message)

    # @unittest.skip
    @pytest.mark.task(taskno=2)
    def test_reactor_efficiency(self):
        voltage = 10
        theoretical_max_power = 10000

        # The numbers are chosen so that current == 10 x percentage
        test_data = ((1000, 'green'), (999, 'green'), (800, 'green'),
                     (799, 'orange'), (700, 'orange'), (600, 'orange'),
                     (599, 'red'), (560, 'red'), (400, 'red'), (300, 'red'),
                     (299, 'black'), (200, 'black'), (0, 'black'))

        for variant, data in enumerate(test_data, start=1):
            current, expected = data
            with self.subTest(f'variation #{variant}', voltage=voltage, current=current,
                              theoretical_max_power=theoretical_max_power, expected=expected):
                # pylint: disable=assignment-from-no-return
                actual_result = reactor_efficiency(voltage, current, theoretical_max_power)
                failure_message = (f'Expected {expected} but returned {actual_result} '
                                   f'with voltage={voltage}, current={current}, max_pow={theoretical_max_power}')
                self.assertEqual(expected, actual_result, failure_message)

    # @unittest.skip
    @pytest.mark.task(taskno=3)
    def test_fail_safe(self):
        temp = 10
        threshold = 10000
        test_data = ((399, 'LOW'), (300, 'LOW'), (1, 'LOW'),
                     (0, 'LOW'), (901, 'NORMAL'), (1000, 'NORMAL'),
                     (1099, 'NORMAL'), (899, 'LOW'), (700, 'LOW'),
                     (400, 'LOW'), (1101, 'DANGER'), (1200, 'DANGER'))

        for variant, (neutrons_per_second, expected) in enumerate(test_data, start=1):
            with self.subTest(f'variation #{variant}', temp=temp, neutrons_per_second=neutrons_per_second,
                              threshold=threshold, expected=expected):
                # pylint: disable=assignment-from-no-return
                actual_result = fail_safe(temp, neutrons_per_second, threshold)
                failure_message = (f'Expected {expected} but returned {actual_result} with T={temp}, '
                                   f'neutrons={neutrons_per_second}, threshold={threshold}')
                self.assertEqual(expected, actual_result, failure_message)

    # @unittest.skip
    @pytest.mark.task(taskno=4)
    def test_efficiency(self):
        voltage = 10
        theoretical_max_power = 10000

        # The numbers are chosen so that current == 10 x percentage
        test_data = ((1000, 1), (999, 0.999), (800, 0.8),
                     (799, 0.799), (700, 0.7), (600, 0.6),
                     (599, 0.599), (560, 0.56), (400, 0.4), (300, 0.3),
                     (299, 0.299), (200, 0.2), (0, 0))

        for variant, data in enumerate(test_data, start=1):
            current, expected = data
            with self.subTest(f'variation #{variant}', voltage=voltage, current=current,
                              theoretical_max_power=theoretical_max_power, expected=expected):
                # pylint: disable=assignment-from-no-return
                actual_result = efficiency_ratio(voltage, current, theoretical_max_power)
                failure_message = (f'Expected {expected} but returned {actual_result} '
                                   f'with voltage={voltage}, current={current}, max_pow={theoretical_max_power}')
                self.assertEqual(expected, actual_result, failure_message)

    # @unittest.skip
    @pytest.mark.task(taskno=5)
    def test_fail_safe_ratio(self):
        temp = 10
        threshold = 10000
        test_data = ((399, 0.399), (300, 0.3), (1, 0.001),
                     (0, 0), (901, 0.901), (1000, 1),
                     (1099, 1.099), (899, 0.899), (700, 0.7),
                     (400, 0.4), (1101, 1.101), (1200, 1.2))

        for variant, (neutrons_per_second, expected) in enumerate(test_data, start=1):
            with self.subTest(f'variation #{variant}', temp=temp, neutrons_per_second=neutrons_per_second,
                              threshold=threshold, expected=expected):
                # pylint: disable=assignment-from-no-return
                actual_result = fail_safe_ratio(temp, neutrons_per_second, threshold)
                failure_message = (f'Expected {expected} but returned {actual_result} with T={temp}, '
                                   f'neutrons={neutrons_per_second}, threshold={threshold}')
                self.assertEqual(expected, actual_result, failure_message)

    # @unittest.skip
    @pytest.mark.task(taskno=6)
    def test_efficiency_color_code(self):
        test_data = ((1, 'green'), (0.999, 'green'), (0.800, 'green'),
                     (0.799, 'orange'), (0.700, 'orange'), (0.600, 'orange'),
                     (0.599, 'red'), (0.560, 'red'), (0.400, 'red'), (0.300, 'red'),
                     (0.299, 'black'), (0.200, 'black'), (0, 'black'))

        for variant, data in enumerate(test_data, start=1):
            ratio, expected = data
            with self.subTest(f'variation #{variant}', ratio=ratio, expected=expected):
                # pylint: disable=assignment-from-no-return
                actual_result = efficiency_color_code(ratio)
                failure_message = (f'Expected {expected} but returned {actual_result} '
                                   f'with ratio={ratio}')
                self.assertEqual(expected, actual_result, failure_message)

    # @unittest.skip
    @pytest.mark.task(taskno=7)
    def test_fail_safe_code(self):
        test_data = ((0.399, 'LOW'), (0.300, 'LOW'), (0.001, 'LOW'),
                     (0, 'LOW'), (0.901, 'NORMAL'), (1.000, 'NORMAL'),
                     (1.099, 'NORMAL'), (0.899, 'LOW'), (0.700, 'LOW'),
                     (0.400, 'LOW'), (1.101, 'DANGER'), (1.200, 'DANGER'))

        for variant, data in enumerate(test_data, start=1):
            ratio, expected = data
            with self.subTest(f'variation #{variant}', ratio=ratio, expected=expected):
                # pylint: disable=assignment-from-no-return
                actual_result = fail_safe_code(ratio)
                failure_message = (f'Expected {expected} but returned {actual_result} '
                                   f'with ratio={ratio}')
                self.assertEqual(expected, actual_result, failure_message)
