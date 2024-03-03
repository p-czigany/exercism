class Reverser
  def self.reverse(string)
    reversed = ''
    chars = string.chars
    string.length.times { reversed << chars.pop }
    reversed
  end
end
