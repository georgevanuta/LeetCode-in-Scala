package MaxAncestorDiff



class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
object Solution {
	def maxAncestorDiff(root: TreeNode, currAncestors: List[Int] = List()): Int = {
		if (root == null) Int.MinValue
		else if (currAncestors.isEmpty) {
			Math.max(
				maxAncestorDiff(root.left, root.value :: currAncestors),
				maxAncestorDiff(root.right, root.value :: currAncestors)
			)
		}
		else {
			val ANCESTOR_DIFF: Int =
				currAncestors
				.map(
					ancestor => Math.abs(ancestor - root.value)
				)
				.max

			Math.max(
				ANCESTOR_DIFF,
				Math.max(
					maxAncestorDiff(root.left, root.value :: currAncestors),
					maxAncestorDiff(root.right, root.value :: currAncestors)
				)
			)
		}
	}
}
