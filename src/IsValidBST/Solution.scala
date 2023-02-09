package IsValidBST


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/validate-binary-search-tree/description/
object Solution {
	def isValidBST(root: TreeNode): Boolean = {
		def forAll(el: Int, tree: TreeNode, op: (Int, Int) => Boolean): Boolean = {
			if (tree == null) true
			else
				op(el, tree.value) &&
				forAll(el, tree.left, op) &&
				forAll(el, tree.right, op)
		}

		if (root == null) true
		else
			forAll(root.value, root.left, (x1, x2) => x1 > x2) &&
			forAll(root.value, root.right, (x1, x2) => x1 < x2) &&
			isValidBST(root.left) &&
			isValidBST(root.right)
	}
}
