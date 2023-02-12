package CountElements


// https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
object Solution {
	def countElements(nums: Array[Int]): Int = {
		val MIN: Int = nums.min
		val MAX: Int = nums.max

		Math.max(
			0,
			nums
			.length -
			(
			nums.count(_ == MIN) +
			nums.count(_ == MAX)
			)
		)
	}
}
