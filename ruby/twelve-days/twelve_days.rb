# frozen_string_literal: true

# Write your code for the 'Twelve Days' exercise in this file. Make the tests in
# `twelve_days_test.rb` pass.
#
# To get started with TDD, see the `README.md` file in your
# `ruby/twelve-days` directory.
class TwelveDays
  ORDINALS = %w[first second third fourth fifth sixth seventh eighth ninth tenth eleventh twelfth].freeze
  GIFTS = ['a Partridge in a Pear Tree',
           'two Turtle Doves',
           'three French Hens',
           'four Calling Birds',
           'five Gold Rings',
           'six Geese-a-Laying',
           'seven Swans-a-Swimming',
           'eight Maids-a-Milking',
           'nine Ladies Dancing',
           'ten Lords-a-Leaping',
           'eleven Pipers Piping',
           'twelve Drummers Drumming'].freeze

  def self.song
    verse 1
  end

  def self.verse(verse_number)
    if verse_number == 1
      return "On the #{ORDINALS[verse_number - 1]} day of Christmas my true love gave to me: #{GIFTS[verse_number - 1]}."
    end
    if verse_number == 2
      return "On the #{ORDINALS[verse_number - 1]} day of Christmas my true love gave to me: #{GIFTS[verse_number - 1]}, and #{GIFTS[verse_number - 2]}."
    end
    return unless verse_number == 3

    "On the #{ORDINALS[verse_number - 1]} day of Christmas my true love gave to me: #{GIFTS[verse_number - 1]}, #{GIFTS[verse_number - 2]}, and #{GIFTS[0]}."
  end

  def self.enumerate_gifts(verse_number)
    enumerate_first_part_of_gifts(verse_number).concat([GIFTS[0]]).join(', and ')
  end

  def self.enumerate_first_part_of_gifts(verse_number)
    return [] if verse_number < 2

    [GIFTS[1..verse_number - 1].reverse.join(', ')]
  end
end
