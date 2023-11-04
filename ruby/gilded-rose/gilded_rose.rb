# frozen_string_literal: true

# Fine good, possibly for sale in the famed Gilded Rose inn.
class ItemForSale
  attr_accessor :name, :sell_in, :quality

  def initialize(name, sell_in, quality)
    @name = name
    @sell_in = sell_in
    @quality = quality
  end

  def change_quality(delta)
    @quality += delta
    @quality = 50 if @quality > 50
    return unless @quality.negative?

    @quality = 0
  end
end

# Any fine good not covered by the exceptions.
class RegularItem < ItemForSale
  def update
    change_quality @sell_in < 1 ? -2 : -1
    @sell_in -= 1
  end
end

# Legendary item - timeless.
class Sulfuras < ItemForSale
  def update; end
end

# Cheese - tastier with age.
class AgedBrie < ItemForSale
  def update
    change_quality @sell_in.positive? ? 1 : 2
    @sell_in -= 1
  end
end

# Backstage passes to a concert.
class BackstagePass < ItemForSale
  def update
    case @sell_in
    when -Float::INFINITY..0
      @quality = 0
    when 0..5
      change_quality(3)
    when 6..10
      change_quality(2)
    else
      change_quality(1)
    end
    @sell_in -= 1
  end
end

# Factory class for the different item types.
class Item
  def self.new(name:, sell_in:, quality:)
    case name
    when 'Sulfuras, Hand of Ragnaros'
      Sulfuras.new(name, sell_in, quality)
    when 'Aged Brie'
      AgedBrie.new(name, sell_in, quality)
    when 'Backstage passes to a TAFKAL80ETC concert'
      BackstagePass.new(name, sell_in, quality)
    else
      RegularItem.new(name, sell_in, quality)
    end
  end
end

# Inventory system of the famed Gilded Rose inn that buys and sells only the finest goods.
class GildedRose
  def initialize(items)
    @items = items
  end

  def update!
    @items.each(&:update)
  end
end
