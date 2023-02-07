package SumBT

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 	var value: Int = _value
 	var left: TreeNode = _left
 	var right: TreeNode = _right
}


// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/submissions/
object Solution {
	def sumRootToLeaf(root: TreeNode, currentSum: String = ""): Int = {
		if (root == null && currentSum.isEmpty) return 0
		if (root == null) {
			return Integer.parseInt(currentSum, 2)
		}

		if (root.left == null) return sumRootToLeaf(root.right, currentSum ++ root.value.toString)
		if (root.right == null) return sumRootToLeaf(root.left, currentSum ++ root.value.toString)

		sumRootToLeaf(root.left, currentSum ++ root.value.toString) +
		sumRootToLeaf(root.right, currentSum ++ root.value.toString)
	}
}

