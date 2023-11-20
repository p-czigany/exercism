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

  def self.first_turn(_card1, _card2, _dealer_card)
    raise 'Please implement the Blackjack.first_turn method'
  end
end
