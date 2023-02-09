package FindSecondMinimumValue


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
object Solution {
	def findSecondMinimumValue(root: TreeNode): Int = {
		def traverse(root: TreeNode): List[Int] = {
			if (root == null) List()
			else root.value :: (traverse(root.left) ++ traverse(root.right))
		}


		val TRAVERSAL: List[Int] = traverse(root).distinct

		if (TRAVERSAL.size < 2) -1
		else {
			val FIRST_MIN: Int = TRAVERSAL.min

			val SECOND_MIN: Int =
				TRAVERSAL
				.filterNot(_ == FIRST_MIN)
				.min

			SECOND_MIN
		}

	}
}
