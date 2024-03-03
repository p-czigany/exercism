class Sieve
  private

  attr_reader :upper_limit

  def initialize(upper_limit)
    @upper_limit = upper_limit
  end

  def delete_multiples(arr, prime)
    (prime**2 - 1...upper_limit).step(prime) { |index| arr[index] = false }
  end

  def collect_primes_from_sieve(primes, sieve)
    (2..upper_limit).each { |number| primes << number if sieve[number - 1] }
  end

  public

  def primes
    primes = []
    sieve = Array.new(upper_limit, true)
    return primes unless sieve.size >= 2

    index = 0
    until index >= Integer.sqrt(upper_limit)
      index += 1
      next unless sieve[index]

      delete_multiples(sieve, index + 1)
    end

    collect_primes_from_sieve(primes, sieve)
    primes
  end
end
