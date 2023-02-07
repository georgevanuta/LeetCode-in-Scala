package IncreasingBST

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
 	var left: TreeNode = _left
 	var right: TreeNode = _right
}


// https://leetcode.com/problems/increasing-order-search-tree/
object Solution {
	def increasingBST(root: TreeNode): TreeNode = {
		def sorted(r: TreeNode): List[Int] = {
			if (r == null) List()
			else sorted(r.left) ++ List(r.value) ++ sorted(r.right)
		}

		def toSortedBST(l: List[Int]): TreeNode = {
			if (l.isEmpty) null
			else new TreeNode(l.head, null, toSortedBST(l.tail))
		}

		val sortedBST: List[Int] = sorted(root)

		toSortedBST(sortedBST)
	}
}