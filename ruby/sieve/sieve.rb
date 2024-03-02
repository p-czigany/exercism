class Sieve
  def initialize(upper_limit)
    @upper_limit = upper_limit
  end

  def primes
    primes = []
    (2..upper_limit).each do |current|
      primes << current if prime? current
    end
    primes
  end

  private

  def prime?(current)
    (2..Integer.sqrt(current)).each do |possible_divider|
      return false if (current % possible_divider).zero?
    end
    true
  end

  attr_reader :upper_limit
end
