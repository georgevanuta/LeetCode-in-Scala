package GoodNodes


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
object Solution {
	def goodNodes(root: TreeNode, currMax: Int = Int.MinValue): Int = {
		if (root == null) 0
		else if (root.value >= currMax)
			1 +
			goodNodes(root.left, root.value) +
			goodNodes(root.right, root.value)
		else
			goodNodes(root.left, currMax) +
			goodNodes(root.right, currMax)
	}
}
