# frozen_string_literal: true

class Sieve
  def initialize(upper_limit)
    @upper_limit = upper_limit
  end

  def primes
    possible_primes = (2..@upper_limit).to_a
    primes = []
    until possible_primes.empty?
      current = possible_primes.shift
      next unless prime? current

      possible_primes = remove_multiples(possible_primes, current)
      primes << current
    end
    primes
  end

  def prime?(current)
    (2..current - 1).each do |possible_divider|
      return false if (current % possible_divider).zero?
    end
    true
  end

  def remove_multiples(numbers, divider)
    numbers.filter { |num| num % divider != 0 }
  end
end
