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

  def self.parse_card(card)
    CARD_VALUES.fetch(card, 0)
  end

  def self.card_range(card1, card2)
    case (parse_card card1) + (parse_card card2)
    when ..11 then 'low'
    when ..16 then 'mid'
    when ..20 then 'high'
    else 'blackjack'
    end
  end

  def self.first_turn(card1, card2, dealer_card)
    return 'P' if card1 == 'ace' && card2 == 'ace'

    if card_range(card1, card2) == 'blackjack'
      return 'W' if parse_card(dealer_card) < 10

      return 'S'
    end
    return 'S' if card_range(card1, card2) == 'high'

    return 'S' if card_range(card1, card2) == 'mid' && parse_card(dealer_card) < 7

    'H'
  end
end
