class Sieve
  def initialize(upper_limit)
    @upper_limit = upper_limit
  end

  def primes
    primes = []
    (2..upper_limit).each do |current|
      primes << current if prime? primes, current
    end
    primes
  end

  private

  def prime?(primes, current)
    binary_search_less_than_or_equal(primes, Integer.sqrt(current)).each do |possible_divider|
      return false if (current % possible_divider).zero?
    end
    true
  end

  attr_reader :upper_limit

  def binary_search_less_than_or_equal(arr, target)
    left = 0
    right = arr.length - 1
    index = -1

    while left <= right
      mid = (left + right) / 2

      if arr[mid] <= target
        index = mid
        left = mid + 1
      else
        right = mid - 1
      end
    end

    arr[0..index]
  end
end
