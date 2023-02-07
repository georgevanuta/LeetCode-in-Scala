package RightSideBT

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 	var value: Int = _value
 	var left: TreeNode = _left
 	var right: TreeNode = _right
}

object Solution {
	def nodesAtLevel(root: TreeNode, level: Int, currentLevel: Int = 0): List[Int] = {
		if (root == null) return List()
		if (currentLevel == level) return List(root.value)

		nodesAtLevel(root.left, level, currentLevel + 1) ++
		nodesAtLevel(root.right, level, currentLevel + 1)
	}

	def heightOfBT(root: TreeNode): Int = {
		if (root == null) return 0

		1 + Math.max(heightOfBT(root.left), heightOfBT(root.right))
	}

	def rightSideView(root: TreeNode): List[Int] = {
		val height: Int = heightOfBT(root)

		(0 to height).foldRight(List[Int]())(
			(level, rightSide) => {
				rightSide :+ nodesAtLevel(root, level).last
			}
		)
	}
}