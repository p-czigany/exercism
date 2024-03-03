class DndCharacter
  BASE_HITPOINTS = 10

  def self.modifier(stat)
    Integer((stat - 10) / 2).floor
  end

  def self.roll_d6
    rand(1..6)
  end

  def self.roll_attribute
    rolls = []
    lowest = 7
    4.times do
      roll = roll_d6
      lowest = roll if roll < lowest
      rolls << roll
    end
    rolls.sum - lowest
  end

  private

  def initialize
    @strength = self.class.roll_attribute
    @dexterity = self.class.roll_attribute
    @constitution = self.class.roll_attribute
    @intelligence = self.class.roll_attribute
    @wisdom = self.class.roll_attribute
    @charisma = self.class.roll_attribute

    @hitpoints = self.class.modifier(constitution) + BASE_HITPOINTS
  end

  public

  attr_reader :strength, :dexterity, :constitution, :intelligence, :wisdom, :charisma, :hitpoints
end
