package ZigZagLevelOrder


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
object Solution {
	def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
		def getLevel(root: TreeNode, level: Int, currLevel: Int = 0): List[Int] = {
			if (root == null) List()
			else if (currLevel == level) List(root.value)
			else
				getLevel(root.left, level, currLevel + 1) ++
				getLevel(root.right, level, currLevel + 1)
		}


		def getHeight(root: TreeNode): Int = {
			if (root == null) 0
			else {
				1 +
				Math
				.max(
					getHeight(root.left),
					getHeight(root.right)
				)
			}
		}


		(0 until getHeight(root))
		.map(level => getLevel(root, level))
		.zipWithIndex
		.map(
			currLevel => {
				val INDEX: Int = currLevel._2

				if (INDEX % 2 == 0) currLevel._1
				else currLevel._1.reverse
			}
		)
		.toList
	}
}