package SearchBST


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/search-in-a-binary-search-tree/description/
object Solution {
	def searchBST(root: TreeNode, `val`: Int): TreeNode = {
		if (root == null) null
		else if (root == `val`) root
		else if (`val` < root.value) searchBST(root.left, `val`)
		else searchBST(root.right, `val`)
	}
}


