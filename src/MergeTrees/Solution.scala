package MergeTrees


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/merge-two-binary-trees/
object Solution {
	def mergeTrees(root1: TreeNode, root2: TreeNode): TreeNode = {
		if (root1 == null && root2 == null) null
		else if (root1 == null) root2
		else if (root2 == null) root1
		else new TreeNode(
			root1.value + root2.value,
			mergeTrees(root1.left, root2.left),
			mergeTrees(root1.right, root2.right)
		)
	}
}
