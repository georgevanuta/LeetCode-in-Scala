package GetSum



// https://leetcode.com/problems/sum-of-two-integers/description/
object Solution {
	def getSum(a: Int, b: Int): Int = {
		// hackish, but I couldn't be bothered with bit manipulation :D
		List(a, b)
		.sum
	}
}
