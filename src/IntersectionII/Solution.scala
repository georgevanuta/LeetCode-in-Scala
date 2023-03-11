package IntersectionII


// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
object Solution {
	def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
		// could have used nums1.intersect(nums2) but it seemed too cheesy

		nums1
		.toSet
		.toArray
		.flatMap(
			el =>
				Array.fill(
					Math.min(
						nums1.count(_ == el),
						nums2.count(_ == el)
					)
				)
				(el)
		)
	}
}
