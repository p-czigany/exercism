# frozen_string_literal: true

module Blackjack
  CARD_VALUES = {
    'ace' => 11,
    'two' => 2,
    'three' => 3,
    'four' => 4,
    'five' => 5,
    'six' => 6,
    'seven' => 7,
    'eight' => 8,
    'nine' => 9,
    'ten' => 10,
    'jack' => 10,
    'queen' => 10,
    'king' => 10
  }.freeze

  attr_accessor :player_cards, :dealer_cards

  def self.parse_card(card)
    CARD_VALUES.fetch(card, 0)
  end

  def self.card_range(*cards)
    total_value = cards.sum { |card| parse_card card }

    case total_value
    when ..11 then 'low'
    when ..16 then 'mid'
    when ..20 then 'high'
    else 'blackjack'
    end
  end

  def self.first_turn(card1, card2, dealer_card)
    @player_cards = [card1, card2]
    @dealer_card = dealer_card
    return 'P' if split_condition
    return 'W' if win_condition
    return 'S' if stand_condition

    'H'
  end

  def self.split_condition
    @player_cards.all? { |card| card == 'ace' }
  end

  def self.win_condition
    blackjack? && dealer_under_10?
  end

  def self.stand_condition
    high_range? || (mid_range? && dealer_under_7?) || blackjack?
  end

  def self.high_range?
    range? 'high'
  end

  def self.mid_range?
    range? 'mid'
  end

  def self.blackjack?
    range? 'blackjack'
  end

  def self.range?(range)
    card_range(*@player_cards) == range
  end

  def self.dealer_under_10?
    dealer_under_value? 10
  end

  def self.dealer_under_7?
    dealer_under_value? 7
  end

  def self.dealer_under_value?(value)
    parse_card(@dealer_card) < value
  end
end
