package MissingNumber

// https://leetcode.com/problems/missing-number
object Solution {
	def missingNumber(nums: Array[Int]): Int = {
		nums.length * (nums.length + 1) / 2 - nums.sum
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		println(Solution.missingNumber(Array(2, 1, 3, 4)))
	}
}