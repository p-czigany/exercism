"""Functions to help Azara and Rui locate pirate treasure."""
AZARA_COORDINATE_INDEX = 1
RUI_COORDINATE_INDEX = 1
INDEX_OF_REDUNDANT_COORDINATE = 1


def get_coordinate(record):
    """Return coordinate value from a tuple containing the treasure name, and treasure coordinate.

    :param record: tuple - with a (treasure, coordinate) pair.
    :return: str - the extracted map coordinate.
    """

    return record[AZARA_COORDINATE_INDEX]


def convert_coordinate(coordinate):
    """Split the given coordinate into tuple containing its individual components.

    :param coordinate: str - a string map coordinate
    :return: tuple - the string coordinate split into its individual components.
    """

    return tuple(coordinate)


def compare_records(azara_record, rui_record):
    """Compare two record types and determine if their coordinates match.

    :param azara_record: tuple - a (treasure, coordinate) pair.
    :param rui_record: tuple - a (location, tuple(coordinate_1, coordinate_2), quadrant) trio.
    :return: bool - do the coordinates match?
    """

    return rui_record[RUI_COORDINATE_INDEX] == convert_coordinate(azara_record[AZARA_COORDINATE_INDEX])


def create_record(azara_record, rui_record):
    """Combine the two record types (if possible) and create a combined record group.

    :param azara_record: tuple - a (treasure, coordinate) pair.
    :param rui_record: tuple - a (location, coordinate, quadrant) trio.
    :return: tuple or str - the combined record (if compatible), or the string "not a match" (if incompatible).
    """

    return azara_record + rui_record if compare_records(azara_record, rui_record) else "not a match"


def clean_up(combined_record_group):
    """Clean up a combined record group into a multi-line string of single records.

    :param combined_record_group: tuple - everything from both participants.
    :return: str - everything "cleaned", excess coordinates and information are removed.

    The return statement should be a multi-lined string with items separated by newlines.

    (see HINTS.md for an example).
    """

    return "".join(clean_up_record(line) for line in combined_record_group)


def clean_up_record(combined_record):
    return str(remove_redundant_coordinate(combined_record)) + "\n"


def remove_redundant_coordinate(combined_record):
    record_as_list = list(combined_record)
    record_as_list.pop(INDEX_OF_REDUNDANT_COORDINATE)
    return tuple(record_as_list)
