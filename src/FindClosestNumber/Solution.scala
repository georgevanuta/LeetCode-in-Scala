package FindClosestNumber


// https://leetcode.com/problems/find-closest-number-to-zero/description/
object Solution {
	def findClosestNumber(nums: Array[Int]): Int = {
		val ABS_NUMS: Set[(Int, Int)] =
			nums
			.map(
				n => {
					if (n < 0) (-n, -1)
					else (n, 1)
				}
			)
			.toSet

		val MIN: Int =
			ABS_NUMS
			.minBy(_._1)
			._1

		val MINIMUMS: Set[(Int, Int)] =
			ABS_NUMS
			.filter(_._1 == MIN)

		if (MINIMUMS.map(_._2).contains(1))
			MINIMUMS
			.filter(_._2 == 1)
			.head
			._1

		else
			MINIMUMS
			.head
			._1 *
			-1
	}
}
