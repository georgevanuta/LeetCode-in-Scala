package CheckTree


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/root-equals-sum-of-children/
object Solution {
	def checkTree(root: TreeNode): Boolean = {
		root.value == root.left.value + root.right.value
	}
}