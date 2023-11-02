require 'minitest/autorun'
require_relative 'boutique_inventory'

class BoutiqueInventoryTest < Minitest::Test
  def test_no_item_names
    # skip
    assert_empty BoutiqueInventory.new([]).item_names
  end

  def test_one_item_name
    # skip
    items = [
      { price: 65.00, name: "Red Brown Dress", quantity_by_size: {} }
    ]
    names = ["Red Brown Dress"]
    assert_equal names, BoutiqueInventory.new(items).item_names
  end

  def test_three_item_names
    # skip
    items = [
      { price: 65.00, name: "Red Brown Dress", quantity_by_size: {} },
      { price: 50.00, name: "Red Short Skirt", quantity_by_size: {} },
      { price: 29.99, name: "Black Short Skirt", quantity_by_size: {} }
    ]
    names = ["Black Short Skirt", "Red Brown Dress", "Red Short Skirt"]
    assert_equal names, BoutiqueInventory.new(items).item_names
  end

  def test_total_stock_for_no_items
    # skip
    assert_equal 0, BoutiqueInventory.new([]).total_stock
  end

  def test_total_stock_for_no_stock
    # skip
    shoes = { price: 30.00, name: "Shoes", quantity_by_size: {} }
    coat = { price: 65.00, name: "Coat", quantity_by_size: {} }
    items = [shoes, coat]
    assert_equal 0, BoutiqueInventory.new(items).total_stock
  end

  def test_total_stock_for_some_items
    # skip
    shoes = { price: 30.00, name: "Shoes", quantity_by_size: { s: 1, xl: 4 } }
    coat = { price: 65.00, name: "Coat", quantity_by_size: {} }
    handkerchief = { price: 19.99, name: "Handkerchief", quantity_by_size: {} }
    items = [shoes, coat, handkerchief]
    assert_equal 5, BoutiqueInventory.new(items).total_stock
  end

  def test_items_is_an_array_of_ostruct
    # skip
    shoes = { price: 30.00, name: "Shoes", quantity_by_size: { s: 1, xl: 4 } }
    coat = { price: 65.00, name: "Coat", quantity_by_size: { m: 1, l: 2 } }
    handkerchief = { price: 19.99, name: "Handkerchief", quantity_by_size: { s: 3, m: 2 } }
    items = [shoes, coat, handkerchief]
    assert_equal Array, BoutiqueInventory.new(items).items.class
    assert_equal OpenStruct, BoutiqueInventory.new(items).items.first.class
  end
end
