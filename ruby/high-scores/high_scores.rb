# frozen_string_literal: true

# High scores of a single person
class HighScores
  def initialize(scores)
    @scores = scores
  end

  attr_reader :scores

  def latest
    @scores[-1]
  end

  def personal_best
    @scores.max
  end

  def personal_top_three
    @scores.sort.reverse[..2]
  end

  def latest_is_personal_best?
    latest == personal_best
  end
end
