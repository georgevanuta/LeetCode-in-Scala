package GetAllElements


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
object Solution {
	def getAllElements(root1: TreeNode, root2: TreeNode): List[Int] = {
		def getOrder(root: TreeNode): List[Int] = {
			if (root == null) List()
			else
				getOrder(root.left) ++
				List(root.value) ++
				getOrder(root.right)
		}

		val order1: List[Int] = getOrder(root1)
		val order2: List[Int] = getOrder(root2)

		def mergeSortedLists(l1: List[Int], l2: List[Int]): List[Int] = {
			if (l1.isEmpty) l2
			else if (l2.isEmpty) l1
			else if (l1.head < l2.head) l1.head :: mergeSortedLists(l1.tail, l2)
			else l2.head :: mergeSortedLists(l1, l2.tail)
		}

		mergeSortedLists(order1, order2)
	}
}