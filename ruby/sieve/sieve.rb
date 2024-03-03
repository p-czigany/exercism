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

  def calculate
    primes = []
    sieve = Array.new(upper_limit, true)
    (1..Integer.sqrt(upper_limit - 1)).each do |index|
      next unless sieve[index]

      delete_multiples(sieve, index + 1)
    end

    collect_primes_from_sieve(primes, sieve)
    primes
  end

  public

  def primes
    @primes ||= calculate
  end
end
