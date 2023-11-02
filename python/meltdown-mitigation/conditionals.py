"""Functions to prevent a nuclear meltdown."""
CRITICAL_TEMPERATURE_UPPER_LIMIT = 800
CRITICAL_NEUTRON_EMISSION_LOWER_LIMIT = 500
CRITICAL_PRODUCT_UPPER_LIMIT = 500000

GREEN_BAND_LOW_POINT = 0.8
ORANGE_BAND_LOW_POINT = 0.6
RED_BAND_LOW_POINT = 0.3

GREEN_EFFICIENCY_BAND = 'green'
ORANGE_EFFICIENCY_BAND = 'orange'
RED_EFFICIENCY_BAND = 'red'
BLACK_EFFICIENCY_BAND = 'black'

FAIL_SAFE_DANGER_LOW_POINT = 1.1
FAIL_SAFE_NORMAL_LOW_POINT = 0.9

FAIL_SAFE_DANGER = 'DANGER'
FAIL_SAFE_NORMAL = 'NORMAL'
FAIL_SAFE_LOW = 'LOW'


def is_criticality_balanced(temperature, neutrons_emitted):
    """Verify criticality is balanced.

    :param temperature: int or float - temperature value in kelvin.
    :param neutrons_emitted: int or float - number of neutrons emitted per second.
    :return: bool - is criticality balanced?

    A reactor is said to be critical if it satisfies the following conditions:
    - The temperature is less than 800 K.
    - The number of neutrons emitted per second is greater than 500.
    - The product of temperature and neutrons emitted per second is less than 500000.
    """

    return is_temperature_possibly_critical(temperature) and is_neutron_emission_possibly_critical(
        neutrons_emitted) and is_product_possibly_critical(temperature, neutrons_emitted)


def is_temperature_possibly_critical(temperature):
    return temperature < CRITICAL_TEMPERATURE_UPPER_LIMIT


def is_neutron_emission_possibly_critical(neutrons_emitted):
    return neutrons_emitted > CRITICAL_NEUTRON_EMISSION_LOWER_LIMIT


def is_product_possibly_critical(temperature, neutrons_emitted):
    return temperature * neutrons_emitted < CRITICAL_PRODUCT_UPPER_LIMIT


def reactor_efficiency(voltage, current, theoretical_max_power):
    """Assess reactor efficiency zone.

    :param voltage: int or float - voltage value.
    :param current: int or float - current value.
    :param theoretical_max_power: int or float - power that corresponds to a 100% efficiency.
    :return: str - one of ('green', 'orange', 'red', or 'black').

    Efficiency can be grouped into 4 bands:

    1. green -> efficiency of 80% or more,
    2. orange -> efficiency of less than 80% but at least 60%,
    3. red -> efficiency below 60%, but still 30% or more,
    4. black ->  less than 30% efficient.

    The percentage value is calculated as
    (generated power/ theoretical max power)*100
    where generated power = voltage * current
    """

    return efficiency_color_code(efficiency_ratio(voltage, current, theoretical_max_power))


def efficiency_ratio(voltage, current, theoretical_max_power):
    return voltage * current / theoretical_max_power


def efficiency_color_code(ratio):
    if ratio >= GREEN_BAND_LOW_POINT:
        return GREEN_EFFICIENCY_BAND
    if ratio >= ORANGE_BAND_LOW_POINT:
        return ORANGE_EFFICIENCY_BAND
    if ratio >= RED_BAND_LOW_POINT:
        return RED_EFFICIENCY_BAND
    return BLACK_EFFICIENCY_BAND


def fail_safe(temperature, neutrons_produced_per_second, threshold):
    """Assess and return status code for the reactor.

    :param temperature: int or float - value of the temperature in kelvin.
    :param neutrons_produced_per_second: int or float - neutron flux.
    :param threshold: int or float - threshold for category.
    :return: str - one of ('LOW', 'NORMAL', 'DANGER').

    1. 'LOW' -> `temperature * neutrons per second` < 90% of `threshold`
    2. 'NORMAL' -> `temperature * neutrons per second` +/- 10% of `threshold`
    3. 'DANGER' -> `temperature * neutrons per second` is not in the above-stated ranges
    """

    return fail_safe_code(fail_safe_ratio(temperature, neutrons_produced_per_second, threshold))


def fail_safe_ratio(temperature, neutrons_produced_per_second, threshold):
    return temperature * neutrons_produced_per_second / threshold


def fail_safe_code(ratio):
    if ratio >= FAIL_SAFE_DANGER_LOW_POINT:
        return FAIL_SAFE_DANGER
    if ratio >= FAIL_SAFE_NORMAL_LOW_POINT:
        return FAIL_SAFE_NORMAL
    return FAIL_SAFE_LOW
