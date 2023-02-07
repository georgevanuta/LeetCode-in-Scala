package DeleteNodeBT

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/delete-node-in-a-bst/
object Solution {
	def deleteNode(root: TreeNode, key: Int): TreeNode = {
		def preorder(r: TreeNode): List[Int] = {
			if (r == null) List()
			else preorder(r.left) ++ List(r.value) ++ preorder(r.right)
		}



		def fromPreorderToBST(pre: List[Int]): TreeNode = {
			def insertNodeBST(node: TreeNode, v: Int): TreeNode = {
				if (node == null) new TreeNode(v)
				else if (v <= node.value) new TreeNode(node.value, insertNodeBST(node.left, v), node.right)
				else new TreeNode(node.value, node.left, insertNodeBST(node.right, v))
			}

			if (pre.isEmpty) null
			else
				pre.tail.foldRight(new TreeNode(pre.head))(
					(curr, acc) => insertNodeBST(acc, curr)
				)
		}

		val preorderTraversal: List[Int] = preorder(root)
		val deletedKeyPreorder: List[Int] = preorderTraversal.filter(_ != key)


		fromPreorderToBST(deletedKeyPreorder)
	}
}
