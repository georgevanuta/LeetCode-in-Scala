package GetConcatenation


// https://leetcode.com/problems/concatenation-of-array/description/
object Solution {
	def getConcatenation(nums: Array[Int]): Array[Int] = {
		nums ++ nums
	}
}
