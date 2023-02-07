package MaxDepth


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
object Solution {
	def maxDepth(root: TreeNode): Int = {
		if (root == null) 0
		else 1 + Math.max(
			maxDepth(root.left),
			maxDepth(root.right)
		)
	}
}