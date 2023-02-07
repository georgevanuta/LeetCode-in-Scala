package PruneTree

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/binary-tree-pruning/
object Solution {
	def pruneTree(root: TreeNode): TreeNode = {
		def treeContains(r: TreeNode, value: Int = 1): Boolean = {
			if (r == null) false
			else if (r.value == value) true
			else treeContains(r.left) || treeContains(r.right)
		}


		if (root == null) null
		else if (treeContains(root)) new TreeNode(root.value, pruneTree(root.left), pruneTree(root.right))
		else null
	}
}
