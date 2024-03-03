class Sieve
  private

  attr_reader :upper_limit

  def initialize(upper_limit)
    @upper_limit = upper_limit
  end

  def delete_multiples(arr, prime)
    (2 * prime - 1...arr.length).step(prime) do |index|
      arr[index] = false
    end
  end

  public

  def primes
    primes = []
    sieve = Array.new(upper_limit, true)
    return primes unless sieve.size >= 2

    index = 0
    until index > upper_limit
      index += 1
      next unless sieve[index]

      primes << index + 1
      delete_multiples(sieve, index + 1)
    end
    primes
  end
end
