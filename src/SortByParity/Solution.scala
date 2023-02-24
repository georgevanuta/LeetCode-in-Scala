package SortByParity


// https://leetcode.com/problems/sort-array-by-parity/
object Solution {
	def sortArrayByParity(nums: Array[Int]): Array[Int] = {
		nums
		.filter(_ % 2 == 0) ++
		nums
		.filterNot(_ % 2 == 0)
	}
}
