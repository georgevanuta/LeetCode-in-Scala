package InorderTraversal

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
object Solution {
	def inorderTraversal(root: TreeNode): List[Int] = {
		if (root == null) List()
		else inorderTraversal(root.left) ++ List(root.value) ++ inorderTraversal(root.right)
	}
}