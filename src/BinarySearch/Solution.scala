package BinarySearch

object Solution {
	def searchInsert(nums: Array[Int], target: Int): Int = {
		def searchAux(low: Int, high: Int): Int = {
			if (low > high) return low

			var currentLow: Int = low
			var currentHigh: Int = high

			val middle: Int = (low + high) / 2

			if (target < nums(middle)) {
				currentHigh = middle - 1
				searchAux(currentLow, currentHigh)
			}
			else if (target > nums(middle)) {
				currentLow = middle + 1
				searchAux(currentLow, currentHigh)
			} else middle
		}

		searchAux(0, nums.length - 1)
	}
}