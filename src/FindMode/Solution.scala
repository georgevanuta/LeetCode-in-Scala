package FindMode


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/find-mode-in-binary-search-tree/
object Solution {
	def findMode(root: TreeNode): Array[Int] = {
		def traverse(root: TreeNode): Array[Int] = {
			if (root == null) Array()
			else
				traverse(root.left) ++
				Array(root.value) ++
				traverse(root.right)
		}

		val TRAVERSAL: Array[Int] =
			traverse(root)

		val TRAVERSAL_WITH_OCC: Array[(Int, Int)] =
			TRAVERSAL
			.map(el => (el, TRAVERSAL.count(i => i == el)))
			.distinct

		val MAX_OCC: Int =
			TRAVERSAL_WITH_OCC
			.maxBy(_._2)
			._2

		TRAVERSAL_WITH_OCC
		.filter(pr => pr._2 == MAX_OCC)
		.map(_._1)
	}
}