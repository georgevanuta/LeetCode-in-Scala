package ValidBst

case class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}

object Solution {
	def isValidAux(root: TreeNode, prev: Int, lft: Boolean): Boolean = {
		if (root == null) return true


		lft match {
			case true =>
				if (root.value < prev)
					return isValidAux(root.left, root.value, true) && isValidAux(root.right, root.value, false)
				else
					return false
			case false =>
				if (root.value > prev)
					return isValidAux(root.left, root.value, true) && isValidAux(root.right, root.value, false)
				else
					return false
		}
	}
	def isValidBST(root: TreeNode): Boolean = {
		isValidAux(root.left, root.value, true) && isValidAux(root.right, root.value, false)
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		val tree: TreeNode =
			TreeNode(5,
				TreeNode(4),
				TreeNode(6,
					TreeNode(3),
					TreeNode(7)))
		println(Solution.isValidBST(tree))
	}
}