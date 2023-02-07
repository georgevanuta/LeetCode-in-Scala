package SortedArrayToBST


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
object Solution {
	def sortedArrayToBST(nums: Array[Int]): TreeNode = {
		if (nums.isEmpty) null
		else if (nums.length == 1) new TreeNode(nums.head)
		else {
			val MID: Int = nums.length / 2

			new TreeNode(
				MID,
				sortedArrayToBST(nums.slice(0, MID - 1)),
				sortedArrayToBST(nums.slice(MID + 1, nums.length))
			)
		}
	}
}