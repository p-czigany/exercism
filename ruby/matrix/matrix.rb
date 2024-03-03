class Matrix
  private

  attr_reader :body

  def initialize(body_string)
    row_strings = body_string.split("\n")
    matrix = []
    row_strings.each do |row_string|
      row = row_string.split.map(&:to_i)
      matrix << row
    end
    @body = matrix
  end

  public

  def row(row_num)
    body[row_num - 1]
  end

  def column(column_num)
    column = []
    (0..body.length - 1).each do |row_i|
      column << body[row_i][column_num - 1]
    end
    column
  end
end
