# frozen_string_literal: true

module Blackjack
  def self.parse_card(card)
    case card
    when 'ace' then 11
    when 'two' then 2
    when 'three' then 3
    when 'four' then 4
    when 'five' then 5
    when 'six' then 6
    when 'seven' then 7
    when 'eight' then 8
    when 'nine' then 9
    when 'ten' then 10
    when 'jack' then 10
    when 'queen' then 10
    when 'king' then 10
    else 0
    end
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
