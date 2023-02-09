package DeepestLeavesSum


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/deepest-leaves-sum/description/
object Solution {
	def deepestLeavesSum(root: TreeNode): Int = {
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

		val HEIGHT: Int = getHeight(root)
		val LAST_LEVEL: List[Int] = getLevel(root, HEIGHT - 1)

		LAST_LEVEL.sum
	}
}

