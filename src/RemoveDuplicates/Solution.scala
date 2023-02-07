package RemoveDuplicates


// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
object Solution {
	def removeDuplicates(nums: Array[Int]): Int = {
		var currIndex: Int = 0
		var prevVal: Int = Integer.MIN_VALUE

		for (i <- 0 until nums.length) {
			if (nums(i) != prevVal) {
				prevVal = nums(i)
				nums(currIndex) = nums(i)
				currIndex += 1
			}
		}

		currIndex
	}
}