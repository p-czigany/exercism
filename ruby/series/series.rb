class Series
  private

  attr_reader :string

  def initialize(string)
    @string = string
  end

  public

  def slices(length)
    raise ArgumentError if length > string.length || !length.positive?

    (0..string.length - length).map do |i|
      string[i, length]
    end
  end
end
