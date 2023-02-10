package FlattenBT


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
object Solution {
	def flatten(root: TreeNode): Unit = {
		def preorder(root: TreeNode): List[Int] = {
			if (root == null) List()
			else root.value :: (preorder(root.left) ++ preorder(root.right))
		}

		if (root == null) return

		def listToRightBT(l: List[Int]): TreeNode = {
			if (l.isEmpty) null
			else new TreeNode(l.head, null, listToRightBT(l.tail))
		}

		val PREORDER: List[Int] = preorder(root)
		val AUX_BT: TreeNode = listToRightBT(PREORDER)

		root.left = null
		root.right = AUX_BT.right
	}
}