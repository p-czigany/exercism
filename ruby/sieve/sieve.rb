class Sieve
  def initialize(upper_limit)
    @upper_limit = upper_limit
  end

  def primes
    possible_primes = (2..@upper_limit).to_a
    primes = []
    until possible_primes.empty?
      current = possible_primes.shift
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
end
