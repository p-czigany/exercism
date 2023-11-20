class LogLineParser
  def initialize(line)
    @line = line
  end

  def message
    @line[part_before_message.length..].strip
  end

  def log_level
    @line.match(/^\[(INFO|WARNING|ERROR)\]/)[0].match(/(INFO|WARNING|ERROR)/)[0].downcase
  end

  def part_before_message
    @line.match(/^\[(INFO|WARNING|ERROR)\]: /)[0]
  end

  def reformat
    "#{message} (#{log_level})"
  end
end
