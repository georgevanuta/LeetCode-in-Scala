package NaryMaxDepth


class Node(var _value: Int) {
	var value: Int = _value
	var children: List[Node] = List()
}


// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
object Solution {
	def maxDepth(root: Node): Int = {
		if (root == null) 0
		else
			1 +
			root
			.children
			.foldRight(-1)(
				(curr, acc) => {
					Math.max(
						maxDepth(curr),
						acc
					)
				}
			)
	}
}