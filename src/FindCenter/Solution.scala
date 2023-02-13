package FindCenter


// https://leetcode.com/problems/find-center-of-star-graph/
object Solution {
	def findCenter(edges: Array[Array[Int]]): Int = {
		edges
		.head
		.intersect(
			edges
			.tail
			.head
		)
		.head
	}
}