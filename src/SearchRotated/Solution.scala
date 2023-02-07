package SearchRotated

// https://leetcode.com/problems/search-in-rotated-sorted-array/
object Solution {
	def search(nums: Array[Int], target: Int): Int = {
		val len: Int = nums.length

		if (target == nums.head) return 0

		if (target < nums.head) {
			var foundInd: Int = -1
			for (i <- 1 to nums.length) {
				if (nums(len - i) == target) {
					foundInd = len - i
					return foundInd
				}

				if (nums(len - i) < target) return foundInd
			}
			foundInd
		} else {
			var foundInd: Int = -1
			for (i <- 0 to (nums.length - 1)) {
				if (nums(i) == target) {
					foundInd = i
					return foundInd
				}

				if (nums(i) > target) return foundInd
			}
			foundInd
		}
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		println(Solution.search(Array(1), 0))
	}
}