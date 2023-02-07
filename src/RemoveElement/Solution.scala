package RemoveElement


// https://leetcode.com/problems/remove-element/description/
object Solution {
	def removeElement(nums: Array[Int], `val`: Int): Int = {
		var currIndex: Int = 0
		for (i <- 0 until nums.length) {
			if (nums(i) != `val`) {
				nums(currIndex) = nums(i)
				currIndex += 1
			}
		}

		currIndex
	}
}