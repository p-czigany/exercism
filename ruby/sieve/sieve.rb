class Sieve
  def initialize(upper_limit)
    @upper_limit = upper_limit
  end

  def primes
    primes = []
    sieve = Array.new(upper_limit, true)
    return primes unless sieve.size >= 2

    index = 1
    until index.nil?
      primes << index + 1
      change_every_nth_to_false(sieve, index + 1)
      index = index_of_first_true_after_i(sieve, index)
    end
    primes
  end

  private

  def change_every_nth_to_false(arr, prime)
    (2 * prime - 1...arr.length).step(prime) do |index|
      arr[index] = false
    end
  end

  def index_of_first_true_after_i(arr, ind)
    index = arr[ind + 1..].index(true)
    index.nil? ? nil : index + ind + 1
  end

  attr_reader :upper_limit
end
