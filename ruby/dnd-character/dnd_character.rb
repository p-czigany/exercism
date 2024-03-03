class DndCharacter
  BASE_HITPOINTS = 10

  def self.modifier(stat)
    (stat - 10) / 2
  end

  def self.roll_d6
    rand(1..6)
  end

  def self.roll_attribute
    rolls = []
    lowest = 6
    4.times do
      roll = roll_d6
      lowest = roll if roll < lowest
      rolls << roll
    end
    rolls.sum - lowest
  end

  private

  def initialize
    %i[strength dexterity constitution intelligence wisdom charisma].each do |attribute|
      instance_variable_set("@#{attribute}", self.class.roll_attribute)
    end

    @hitpoints = self.class.modifier(constitution) + BASE_HITPOINTS
  end

  public

  attr_reader :strength, :dexterity, :constitution, :intelligence, :wisdom, :charisma, :hitpoints
end
