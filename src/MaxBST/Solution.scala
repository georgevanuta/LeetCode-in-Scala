package MaxBST

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}

// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
object Solution {
	def isBST(node: TreeNode,
			  min: Double = Double.NegativeInfinity,
			  max: Double = Double.PositiveInfinity): (Boolean, Int) = {

		if (node == null)
			return (true, 0)


		if (node.value <= min || node.value >= max)
			return (false, 0)

		val leftRec: (Boolean, Int) = isBST(node.left, min, node.value)
		val rightRec: (Boolean, Int) = isBST(node.right, node.value, max)

		if (!leftRec._1 || !rightRec._1)
			return (false, 0)

		(leftRec._1 && rightRec._1, leftRec._2 + rightRec._2 + node.value)
	}

	def maxSumBST(root: TreeNode): Int = {



		if (root == null)
			return 0

		val recCheck: (Boolean, Int) = isBST(root)

		if (recCheck._1)
			return List(
				recCheck._2,
				maxSumBST(root.left),
				maxSumBST(root.right)
			).max


		Math.max(maxSumBST(root.left), maxSumBST(root.right))
	}
}

object Main extends App {
	val bt: TreeNode =
		new TreeNode(
			2,
			new TreeNode(
				3,
				new TreeNode(1),
				new TreeNode(4)
			)
		)

	println(Solution.isBST(bt.left))
}