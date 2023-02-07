package LeftSumBT

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  	var value: Int = _value
	var left: TreeNode = _left
  	var right: TreeNode = _right
}

// https://leetcode.com/problems/sum-of-left-leaves/
object Solution {
	private def isLeaf(node: TreeNode): Boolean =
		node.left == null && node.right == null

	def sumOfLeftLeaves(root: TreeNode, isPrevLeft: Boolean = false): Int = {
		if (root == null) 0
		else if (isLeaf(root) && isPrevLeft) root.value
		else if (root == null) 0
		else sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right)
	}
}