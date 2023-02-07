package PivotIndex


// https://leetcode.com/problems/find-pivot-index/
object Solution {
	def pivotIndex(nums: Array[Int], prevSum: Int = 0, currIndex: Int = 0): Int = {
		if (nums.isEmpty) -1
		else if (prevSum == nums.tail.sum) currIndex
		else pivotIndex(nums.tail, prevSum + nums.head, currIndex + 1)
	}
}