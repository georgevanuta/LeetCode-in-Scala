package GetMinimumDifference


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
object Solution {
	def getMinimumDifference(root: TreeNode): Int = {
		def traverse(root: TreeNode): List[Int] = {
			if (root == null) List()
			else
				traverse(root.left) ++
				List(root.value) ++
				traverse(root.right)
		}

		val TRAVERSAL: List[Int] = traverse(root)

		TRAVERSAL
		.zip(TRAVERSAL.tail)
		.map(pr => pr._2 - pr._1)
		.min
	}
}