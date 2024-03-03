class Series
  private

  attr_reader :string

  def initialize(string)
    @string = string
  end

  public

  def slices(length)
    raise ArgumentError if length > string.length || !length.positive?

    ary = []
    (0..string.length - length).each do |i|
      ary << string[i, length]
    end
    ary
  end
end
