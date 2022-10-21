package GrandfatherSum

case class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}

// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
object Solution {
	def getChildren(root: TreeNode): List[TreeNode] = {
		if (root == null) return List()
		if (root.left == null && root.right == null) return List()
		if (root.left == null) return List(root.right)
		if (root.right == null) return List(root.left)
		List(root.left, root.right)
	}
	def getGrandchildrenValues(root: TreeNode): List[Int] = {
		getChildren(root.left).map(_.value).concat(getChildren(root.right).map(_.value))
	}
	def sumEvenGrandparent(root: TreeNode): Int = {
		var sum: Int = 0
		def sumAux(root: TreeNode): Unit = {
			if (root == null) return
			if (root.value % 2 == 0) sum += getGrandchildrenValues(root).sum
			sumAux(root.left)
			sumAux(root.right)
		}
		sumAux(root)
		sum
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		val tr1: TreeNode =
			TreeNode(6,
				TreeNode(7,
					TreeNode(2,
						TreeNode(9)),
					TreeNode(7,
						TreeNode(1),
						TreeNode(4))),
				TreeNode(8,
					TreeNode(1),
					TreeNode(3,
						TreeNode(5))))
		assert(Solution.sumEvenGrandparent(tr1) == 18)

		val tr2: TreeNode =
			TreeNode(1)
		assert(Solution.sumEvenGrandparent(tr2) == 0)
	}
}