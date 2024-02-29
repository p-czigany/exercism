# frozen_string_literal: true

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
    verses = []
    (1..12).each do |verse_number|
      result = verse(verse_number)
      verses << result
    end
    verses.join("\n\n").concat("\n")
  end

  def self.verse(verse_number)
    "On the #{ORDINALS[verse_number - 1]} day of Christmas my true love gave to me: #{enumerate_gifts verse_number}."
  end

  def self.enumerate_gifts(verse_number)
    enumerate_first_part_of_gifts(verse_number).concat([GIFTS[0]]).join(', and ')
  end

  def self.enumerate_first_part_of_gifts(verse_number)
    return [] if verse_number < 2

    [GIFTS[1..verse_number - 1].reverse.join(', ')]
  end
end
