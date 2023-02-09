package RemoveLeafNodes


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/delete-leaves-with-a-given-value/
object Solution {
	def removeLeafNodes(root: TreeNode, target: Int): TreeNode = {
		def isLeaf(root: TreeNode): Boolean =
			root.left == null && root.right == null


		def removeOnce(root: TreeNode): TreeNode = {
			if (root == null) null
			else if (isLeaf(root) && root.value == target) null
			else
				new TreeNode(
					root.value,
					removeOnce(root.left),
					removeOnce(root.right)
				)
		}


		def containsLeaves(root: TreeNode): Boolean = {
			if (root == null) false
			else if (isLeaf(root) && root.value == target) true
			else
				containsLeaves(root.left) ||
				containsLeaves(root.right)
		}


		if (containsLeaves(root)) {
			removeLeafNodes(
				removeOnce(root),
				target
			)
		}
		else root
	}
}