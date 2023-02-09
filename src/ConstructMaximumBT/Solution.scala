package ConstructMaximumBT


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/maximum-binary-tree/
object Solution {
	def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
		if (nums.isEmpty) null
		else {
			val MAX: Int = nums.max
			val MAX_INDEX: Int = nums.indexOf(MAX)
			val LEFT_ARRAY: Array[Int] = nums.slice(0, MAX_INDEX)
			val RIGHT_ARRAY: Array[Int] = nums.slice(MAX_INDEX + 1, nums.length)

			new TreeNode(
				MAX,
				constructMaximumBinaryTree(LEFT_ARRAY),
				constructMaximumBinaryTree(RIGHT_ARRAY)
			)
		}
	}
}