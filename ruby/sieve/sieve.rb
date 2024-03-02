class Sieve
  def initialize(upper_limit)
    @upper_limit = upper_limit
  end

  def primes
    possible_primes = (2..@upper_limit).to_a
    primes = []
    until possible_primes.empty?
      current = possible_primes.shift

      possible_primes = remove_multiples(possible_primes, current)
      primes << current
    end
    primes
  end

  private

  def remove_multiples(numbers, divider)
    numbers.filter { |num| num % divider != 0 }
  end
end
