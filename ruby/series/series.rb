class Series
  private

  attr_reader :string

  def initialize(string)
    @string = string
  end

  public

  def slices(length)
    ary = []
    (0..string.length - length).each do |i|
      ary << string[i, length]
    end
    ary
  end
end
