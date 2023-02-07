package DissapNums

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
object Solution {
	def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
		(1 to nums.size).diff(nums).toList
	}
}