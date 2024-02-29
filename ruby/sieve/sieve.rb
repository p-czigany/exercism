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

  attr_reader :upper_limit

  def prime?(current)
    (2..current - 1).each do |possible_divider|
      return false if (current % possible_divider).zero?
    end
    true
  end
end
