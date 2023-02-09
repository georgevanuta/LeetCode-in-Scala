package RangeSumBST


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/range-sum-of-bst/
object Solution {
	def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
		def ifInRangeReturnVal: Int = if (root.value >= low && root.value <= high) root.value else 0

		if (root == null) 0
		else
			ifInRangeReturnVal +
			rangeSumBST(root.left, low, high) +
			rangeSumBST(root.right, low, high)
	}
}
