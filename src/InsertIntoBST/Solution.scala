package InsertIntoBST


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
object Solution {
	def insertIntoBST(root: TreeNode, `val`: Int): TreeNode = {
		if (root == null)
			new TreeNode(`val`)
		else if (`val` > root.value)
			new TreeNode(
				root.value,
				root.left,
				insertIntoBST(
					root.right,
					`val`
				)
			)
		else
			new TreeNode(
				root.value,
				insertIntoBST(
					root.left,
					`val`
				),
				root.right
			)
	}
}
