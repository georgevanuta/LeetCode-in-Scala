package IsBalanced


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/balanced-binary-tree/description/
object Solution {
	def isBalanced(root: TreeNode): Boolean = {
		def height(r: TreeNode): Int = {
			if (r == null) 0
			else 1 + Math.max(
				height(r.left),
				height(r.right)
			)
		}

		if (root == null) true
		else if (Math.abs(height(root.left) - height(root.right)) <= 1) {
			isBalanced(root.left) && isBalanced(root.right)
		}
		else false
	}
}