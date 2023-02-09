package EvaluateTree


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/evaluate-boolean-binary-tree/
object Solution {
	def evaluateTree(root: TreeNode): Boolean = {
		def isLeaf: Boolean = root.left == null && root.right == null

		def nrToOp: (Boolean, Boolean) => Boolean = {
			if (root.value == 2) (x: Boolean, y: Boolean) => x | y
			else (x: Boolean, y: Boolean) => x & y
		}

		def leafToBool: Boolean = root.value == 1

		if (isLeaf) leafToBool
		else
			nrToOp
			.apply(
				evaluateTree(root.left),
				evaluateTree(root.right)
			)
	}
}