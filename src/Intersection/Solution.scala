package Intersection


// https://leetcode.com/problems/intersection-of-two-arrays/description/
object Solution {
	def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
		nums1
		.intersect(
			nums2
		)
		.distinct
	}
}
