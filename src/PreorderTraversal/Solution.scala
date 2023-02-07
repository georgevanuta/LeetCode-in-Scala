package PreorderTraversal


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
object Solution {
	def preorderTraversal(root: TreeNode): List[Int] = {
		if (root == null) List()
		else root.value :: preorderTraversal(root.left) ++ preorderTraversal(root.right)
	}
}