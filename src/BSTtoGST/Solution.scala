package BSTtoGST

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
object Solution {
	def bstToGst(root: TreeNode): TreeNode = {
		def sumGstNode(r: TreeNode, el: Int): Int = {
			if (r == null) 0
			else if (r.value < el) sumGstNode(r.right, el)
			else r.value + sumGstNode(r.left, el) + sumGstNode(r.right, el)
		}

		def aux(r: TreeNode): TreeNode = {
			if (r == null) null
			else new TreeNode(sumGstNode(root, root.value), aux(r.left), aux(r.right))
		}

		aux(root)
	}
}