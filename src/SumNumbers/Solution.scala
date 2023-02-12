package SumNumbers


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/sum-root-to-leaf-numbers/
object Solution {
	def sumNumbers(root: TreeNode, acc: String = ""): Int = {
		if (root.left == null && root.right == null) (acc ++ root.value.toString).toInt
		else if (root.left == null) sumNumbers(root.right, acc ++ root.value.toString)
		else if (root.right == null) sumNumbers(root.left, acc ++ root.value.toString)
		else
			sumNumbers(root.left, acc ++ root.value.toString) +
			sumNumbers(root.right, acc ++ root.value.toString)
	}
}
