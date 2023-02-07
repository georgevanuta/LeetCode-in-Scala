package IsSymmetric


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/symmetric-tree/description/
object Solution {
	def isSymmetric(root: TreeNode): Boolean = {
		def areSymmetric(r1: TreeNode, r2: TreeNode): Boolean = {
			if (r1 == null && r2 == null) true
			else if (r1 == null || r2 == null) false
			else if (r1.value != r2.value) false
			else areSymmetric(r1.left, r2.right) && areSymmetric(r1.right, r2.left)
		}

		if (root == null) true
		else areSymmetric(root.left, root.right)
	}
}