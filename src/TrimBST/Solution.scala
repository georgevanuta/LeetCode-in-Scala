package TrimBST

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}

// https://leetcode.com/problems/trim-a-binary-search-tree/
object Solution {
	def trimBST(root: TreeNode, low: Int, high: Int): TreeNode = {
		if (root == null) return null

		if (root.value >= low && root.value <= high) {
			return new TreeNode(root.value, trimBST(root.left, low, high), trimBST(root.right, low, high))
		}

		if (root.value < low) {
			return trimBST(root.right, low, high)
		}

		if (root.value > high) {
			return trimBST(root.left, low, high)
		}

		null
	}
}
