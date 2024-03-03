require 'minitest/autorun'
require_relative 'reverser'

class ReverserTest < Minitest::Test
  def test_an_empty_string
    # skip
    assert_equal '', Reverser.reverse('')
  end

  def test_a_letter
    # skip
    assert_equal 'l', Reverser.reverse('l')
  end

  def test_a_word
    # skip
    assert_equal 'le', Reverser.reverse('el')
  end

  def test_a_sentence
    # skip
    input = "Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn."
    expected = ".ngathf lgan'hagw heyl'R uhluhtC hfan'wlgm iulgn'hP"
    assert_equal expected, Reverser.reverse(input)
  end

  def test_a_sentence_a_million_times
    # skip
    input = "Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn."
    1_000_000.times do
      Reverser.reverse(input)
    end
  end

  def test_a_very_long_string
    # skip
    input = "Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn." * 750_000
    Reverser.reverse(input)
  end
end
