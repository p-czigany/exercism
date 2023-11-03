module Chess
  RANKS = 1..8
  FILES = 'A'..'H'
  SUCCESSFUL_MOVE_MESSAGE = '%s moved to %s'
  UNSUCCESSFUL_MOVE_MESSAGE = '%s attempted to move to %s, but that is not a valid square'

  def self.valid_square?(rank, file)
    RANKS.include? rank and FILES.include? file
  end

  def self.nick_name(first_name, last_name)
    first_name[..1].concat(last_name[-2..]).upcase
  end

  def self.move_message(first_name, last_name, square)
    format(message_template(square), nick_name(first_name, last_name), square)
  end

  def self.message_template(square)
    valid_square?(square[1].to_i, square[0]) ? SUCCESSFUL_MOVE_MESSAGE : UNSUCCESSFUL_MOVE_MESSAGE
  end
end
