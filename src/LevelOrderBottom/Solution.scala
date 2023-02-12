package LevelOrderBottom


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
object Solution {
	def levelOrderBottom(root: TreeNode): List[List[Int]] = {
		def getLevel(root: TreeNode, level: Int, currLevel: Int = 0): List[Int] = {
			if (root == null) List()
			else if (level == currLevel) List(root.value)
			else
				getLevel(root.left, level, currLevel + 1) ++
				getLevel(root.right, level, currLevel + 1)
		}


		def getHeight(root: TreeNode): Int = {
			if (root == null) 0
			else
				1 +
				Math.max(
					getHeight(root.left),
					getHeight(root.right)
				)
		}


		val HEIGHT: Int = getHeight(root)

		(0 until HEIGHT)
		.reverse
		.map(getLevel(root, _))
		.toList
	}
}
