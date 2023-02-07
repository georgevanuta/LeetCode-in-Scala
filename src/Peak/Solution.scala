package Peak

// https://leetcode.com/problems/find-peak-element/
object Solution {
	def findPeakElement(nums: Array[Int]): Int = {

		if (nums.size == 1) return 0

		if (nums(nums.size - 1) > nums(nums.size - 2)) return nums.size - 1

		if (nums(0) > nums(1)) return 0

		for (i <- 1 to (nums.size - 2)) {
				if (i != 0 && i != nums.size && nums(i) > nums(i - 1) && nums(i) > nums(i + 1)) {
					return i
				}
		}

		0
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		val s = Array(1, 2)
		println(Solution.findPeakElement(s))
	}
}