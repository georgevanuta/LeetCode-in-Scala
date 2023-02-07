package MinDepth

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/minimum-depth-of-binary-tree/
object Solution {
	def minDepth(root: TreeNode): Int = {
		def hasBothChildren: Boolean = root.left != null && root.right != null

		if (root == null) 0
		else if (hasBothChildren) 1 + Math.min(
			minDepth(root.left),
			minDepth(root.right)
		)
		else 1 + Math.max(
			minDepth(root.left),
			minDepth(root.right)
		)
	}
}