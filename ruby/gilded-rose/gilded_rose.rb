# frozen_string_literal: true

Item = Struct.new(:name, :sell_in, :quality)

# Inventory system of the famed Gilded Rose inn that buys and sells only the finest goods.
class GildedRose
  UPDATE_POLICIES = {
    'Sulfuras, Hand of Ragnaros' => ->(item) {},
    'Aged Brie' =>
    lambda { |item|
      change_quality(item, item.sell_in.positive? ? 1 : 2)
      item.sell_in -= 1
    },
    'Backstage passes to a TAFKAL80ETC concert' =>
    lambda { |item|
      case item.sell_in
      when -Float::INFINITY..0
        item.quality = 0
      when 0..5
        change_quality(item, 3)
      when 6..10
        change_quality(item, 2)
      else
        change_quality(item, 1)
      end
      item.sell_in -= 1
    }
  }.freeze

  def initialize(items)
    @items = items
  end

  def update!
    @items.each do |item|
      if UPDATE_POLICIES.key?(item.name)
        update_policy = UPDATE_POLICIES[item.name]
        update_policy.call(item)
      else
        GildedRose.change_quality(item, item.sell_in < 1 ? -2 : -1)
        item.sell_in -= 1
      end
    end
  end

  def self.change_quality(item, addition)
    item.quality += addition
    item.quality = 50 if item.quality > 50
    return unless item.quality.negative?

    item.quality = 0
  end
end
