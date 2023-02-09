package FindFrequentTreeSum


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/most-frequent-subtree-sum/description/
object Solution {
	def findFrequentTreeSum(root: TreeNode): Array[Int] = {
		def getAllSubSums(root: TreeNode): Array[Int] = {
			def sum(root: TreeNode): Int = {
				if (root == null) 0
				else
					root.value +
					sum(root.left) +
					sum(root.right)
			}

			if (root == null) Array()
			else
				Array(sum(root)) ++
				getAllSubSums(root.left) ++
				getAllSubSums(root.right)
		}

		val allSums: Array[Int] =
			getAllSubSums(root)

		val allSumsOrdered: Set[(Int, Int)] =
			allSums
			.map(sum => (sum, allSums.count(y => y == sum)))
			.sortBy(_._2)
			.toSet

		val maxCount: Int =
			allSumsOrdered
			.maxBy(_._2)
			._2

		allSumsOrdered
		.filter(_._2 == maxCount)
		.toArray
		.map(_._1)
	}
}
