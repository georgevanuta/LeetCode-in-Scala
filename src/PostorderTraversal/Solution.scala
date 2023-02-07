package PostorderTraversal


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// 145. Binary Tree Postorder Traversal
object Solution {
	def postorderTraversal(root: TreeNode): List[Int] = {
		if (root == null) List()
		else postorderTraversal(root.left) ++ postorderTraversal(root.right) :+ root.value
	}
}