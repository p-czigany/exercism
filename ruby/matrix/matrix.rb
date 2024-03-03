class Matrix
  private

  attr_reader :body

  def initialize(body_string)
    @body = body_string.split("\n").map do |row_string|
      row_string.split.map(&:to_i)
    end
  end

  public

  def row(row_num)
    body[row_num - 1]
  end

  def column(column_num)
    (0..body.length - 1).map do |row_i|
      body[row_i][column_num - 1]
    end
  end
end
