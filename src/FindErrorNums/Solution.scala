package FindErrorNums


// https://leetcode.com/problems/set-mismatch/description/
object Solution {
	def findErrorNums(nums: Array[Int]): Array[Int] = {
		Array(
			nums
			.find(i => nums.count(_ == i) == 2) match {
				case Some(value) => value
				case None => throw new IllegalArgumentException("[ERROR]: Number that should appear twice not found")
			},
			(1 to nums.length)
			.diff(nums)
			.head
		)
	}
}