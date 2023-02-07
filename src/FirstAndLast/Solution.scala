package FirstAndLast

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
object Solution {
	def searchRange(nums: Array[Int], target: Int): Array[Int] = {
		if (nums.isEmpty) return Array(-1, -1)

		var first: Int = -1
		var last: Int = -1
		var i: Int = 0
		var j: Int = nums.length - 1

		do {
			if (nums(i) > target) return Array(-1, -1)
			if (nums(j) < target) return Array(-1, -1)

			if (nums(i) == target) first = i
			else i += 1

			if (nums(j) == target) last = j
			else j -= 1

			if (first != -1 && last != -1) return Array(first, last)
		} while (true)

		if (first == -1 && last != -1) return Array(last, last)
		if (first != -1 && last == -1) return Array(first, first)

		Array(first, last)
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		println(Solution.searchRange(Array(1, 2, 2, 3), 2).toList)
	}
}