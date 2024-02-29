# frozen_string_literal: true

require 'minitest/autorun'
require_relative 'twelve_days'

class TwelveDaysTest < Minitest::Test
  def test_the_whole_song
    # skip
    song_file = File.expand_path('song.txt', __dir__)
    expected = IO.read(song_file)
    assert_equal expected, TwelveDays.song
  end

  def test_first_verse
    # skip
    expected_first_verse = 'On the first day of Christmas my true love gave to me: a Partridge in a Pear Tree.'
    assert_equal expected_first_verse, TwelveDays.verse(1)
  end

  def test_second_verse
    # skip
    expected_second_verse = 'On the second day of Christmas my true love gave to me: two Turtle Doves, and a Partridge in a Pear Tree.'
    assert_equal expected_second_verse, TwelveDays.verse(2)
  end

  def test_third_verse
    # skip
    expected_third_verse = 'On the third day of Christmas my true love gave to me: three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.'
    assert_equal expected_third_verse, TwelveDays.verse(3)
  end

  def test_enumerate_gifts_1
    # skip
    expected = 'a Partridge in a Pear Tree'
    assert_equal expected, TwelveDays.enumerate_gifts(1)
  end

  def test_enumerate_gifts_2
    # skip
    expected = 'two Turtle Doves, and a Partridge in a Pear Tree'
    assert_equal expected, TwelveDays.enumerate_gifts(2)
  end

  def test_enumerate_gifts_3
    # skip
    expected = 'three French Hens, two Turtle Doves, and a Partridge in a Pear Tree'
    assert_equal expected, TwelveDays.enumerate_gifts(3)
  end

  def test_enumerate_gifts_all
    # skip
    expected = 'twelve Drummers Drumming, eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree'
    assert_equal expected, TwelveDays.enumerate_gifts(12)
  end
end
