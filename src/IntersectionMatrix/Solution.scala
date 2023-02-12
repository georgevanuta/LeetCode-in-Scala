package IntersectionMatrix


// https://leetcode.com/problems/intersection-of-multiple-arrays/
object Solution {
	def intersection(nums: Array[Array[Int]]): List[Int] = {
		nums
		.tail
		.foldRight(nums.head)(
			(curr, acc) => acc.intersect(curr)
		)
		.toList
		.sorted
	}
}
