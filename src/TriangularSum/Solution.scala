package TriangularSum


// https://leetcode.com/problems/find-triangular-sum-of-an-array/description/
object Solution {
	def triangularSum(nums: Array[Int]): Int = {
		def recurse(newNums: Array[Int] = nums): Int = {
			if (newNums.length == 1) newNums.head
			else {
				recurse(
					newNums
					.zip(newNums.tail)
					.map(pr => (pr._1 + pr._2) % 10)
				)
			}
		}
	}
}
