# frozen_string_literal: true

# Fine good, for sale in the famed Gilded Rose inn.
class ItemForSale
  attr_accessor :name, :sell_in, :quality

  def initialize(name, sell_in, quality)
    @name = name
    @sell_in = sell_in
    @quality = quality
  end

  def update
    update_quality
    update_time
  end

  def update_quality; end

  def update_time
    @sell_in -= 1
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
  def update_quality
    change_quality @sell_in < 1 ? -2 : -1
  end
end

# Legendary item - timeless.
class Sulfuras < ItemForSale
  def update; end
end

# Cheese - tastier with age.
class AgedBrie < ItemForSale
  def update_quality
    change_quality @sell_in.positive? ? 1 : 2
  end
end

# Backstage passes to a concert.
class BackstagePass < ItemForSale
  def update_quality
    case @sell_in
    when -Float::INFINITY..0 then @quality = 0
    when 0..5 then change_quality 3
    when 6..10 then change_quality 2
    else change_quality 1
    end
  end
end

# Conjured fine good, for sale in the famed Gilded Rose inn.
class ConjuredItemForSale < ItemForSale
  def update
    update_quality
    disappear
    update_time
  end

  def disappear
    return unless @sell_in < 1

    @quality = 0
  end
end

# Conjured fine good item - tends to vanish.
class ConjuredRegularItem < ConjuredItemForSale
  def update_quality
    change_quality(-2)
  end
end

# Conjured cheese - gets better until it vanishes.
class ConjuredAgedBrie < ConjuredItemForSale
  def update_quality
    change_quality @sell_in.positive? ? 1 : 2
  end
end

# Conjured Sulfuras - timeless until it isn't there.
class ConjuredSulfuras < ConjuredItemForSale
end

# Conjured backstage passes to a concert
class ConjuredBackstagePass < ConjuredItemForSale
  def update_quality
    case @sell_in
    when -Float::INFINITY..0 then @quality = 0
    when 0..5 then change_quality 2
    when 6..10 then change_quality 1
    else change_quality 0
    end
  end
end

# Factory class for the different item types.
class Item
  def self.new(name:, sell_in:, quality:)
    if name.start_with?('Conjured')
      conjured_item(name, sell_in, quality)
    else
      real_item(name, sell_in, quality)
    end
  end

  def self.conjured_item(name, sell_in, quality)
    case name.split(' ')[1..].join(' ')
    when /^Sulfuras/
      ConjuredSulfuras.new(name, sell_in, quality)
    when /^Aged Brie/
      ConjuredAgedBrie.new(name, sell_in, quality)
    when /^backstage passes/
      ConjuredBackstagePass.new(name, sell_in, quality)
    else
      ConjuredRegularItem.new(name, sell_in, quality)
    end
  end

  def self.real_item(name, sell_in, quality)
    case name
    when /^Sulfuras/
      Sulfuras.new(name, sell_in, quality)
    when /^Aged Brie/
      AgedBrie.new(name, sell_in, quality)
    when /^Backstage passes/
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
