# frozen_string_literal: true

module Blackjack
  def self.parse_card(card)
    case card
    when 'ace'
      11
    when 'two'
      2
    when 'three'
      3
    when 'four'
      4
    when 'five'
      5
    when 'six'
      6
    when 'seven'
      7
    when 'eight'
      8
    when 'nine'
      9
    when 'ten'
      10
    when 'jack'
      10
    when 'queen'
      10
    when 'king'
      10
    else
      0
    end
  end

  def self.card_range(card1, card2)
    raise "Please implement the Blackjack.card_range method"
  end

  def self.first_turn(card1, card2, dealer_card)
    raise "Please implement the Blackjack.first_turn method"
  end
end
