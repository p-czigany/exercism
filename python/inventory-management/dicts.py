"""Functions to keep track and alter inventory."""
from collections import Counter


def create_inventory(items):
    """Create a dict that tracks the amount (count) of each element on the `items` list.

    :param items: list - list of items to create an inventory from.
    :return: dict - the inventory dictionary.
    """

    return Counter(items)


def add_items(inventory, items):
    """Add or increment items in inventory using elements from the items `list`.

    :param inventory: dict - dictionary of existing inventory.
    :param items: list - list of items to update the inventory with.
    :return: dict - the inventory updated with the new items.
    """

    inventory = Counter(inventory)

    inventory.update(items)

    # return Counter(inventory) + Counter(items)
    return inventory


def decrement_items(inventory, items):
    """Decrement items in inventory using elements from the `items` list.

    :param inventory: dict - inventory dictionary.
    :param items: list - list of items to decrement from the inventory.
    :return: dict - updated inventory with items decremented.
    """

    inventory = Counter(inventory)
    inventory.subtract(Counter(items))

    return {item: max(quantity, 0) for item, quantity in inventory.items()}


def remove_item(inventory, item):
    """Remove item from inventory if it matches `item` string.

    :param inventory: dict - inventory dictionary.
    :param item: str - item to remove from the inventory.
    :return: dict - updated inventory with item removed. Current inventory if item does not match.
    """

    inventory = Counter(inventory)
    del inventory[item]

    return inventory


def list_inventory(inventory):
    """Create a list containing all (item_name, item_count) pairs in inventory.

    :param inventory: dict - an inventory dictionary.
    :return: list of tuples - list of key, value pairs from the inventory dictionary.
    """

    return list(available_items(inventory).items())


def available_items(inventory):
    """Filter inventory to available items.

    :param inventory: dict - an inventory dictionary.
    :return: dict - updated dictionary with only items with stocks over 0.
    """

    return {item: count for item, count in inventory.items() if count > 0}
