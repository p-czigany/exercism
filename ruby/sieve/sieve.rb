class Sieve
  private

  attr_reader :upper_limit

  def initialize(upper_limit)
    @upper_limit = upper_limit
  end

  def mark_multiples(sieve, prime)
    (prime**2 - 1...upper_limit).step(prime) do |i|
      sieve[i] = false
    end
  end

  def collect_primes_from_sieve(primes, sieve)
    (2..upper_limit).each do |number|
      primes << number if sieve[number - 1]
    end
  end

  def calculate
    primes = []
    sieve = Array.new(upper_limit, true)
    (1..Integer.sqrt(upper_limit - 1)).each do |i|
      next unless sieve[i]

      mark_multiples(sieve, i + 1)
    end

    collect_primes_from_sieve(primes, sieve)
    primes
  end

  public

  def primes
    @primes ||= calculate
  end
end
