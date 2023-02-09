package KthSmallest


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
object Solution {
	def kthSmallest(root: TreeNode, k: Int): Int = {
		def getOrdered(root: TreeNode): List[Int] = {
			if (root == null) List()
			else
				getOrdered(root.left) ++
				List(root.value) ++
				getOrdered(root.right)
		}

		getOrdered(root)(k - 1)
	}
}