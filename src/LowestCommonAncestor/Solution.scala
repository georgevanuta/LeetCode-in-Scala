package LowestCommonAncestor


class TreeNode(var _value: Int, var _left: TreeNode = null, var _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
object Solution {
	def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
		def getAncestors(root: TreeNode, p: TreeNode, accList: List[TreeNode] = List()): List[TreeNode] = {
			if (root == null) List()
			else if (root == p) p :: accList
			else
				getAncestors(root.left, p, root :: accList) ++
				getAncestors(root.right, p, root :: accList)
		}

		val ANCESTORS_P: List[TreeNode] = getAncestors(root, p)
		val ANCESTORS_Q: List[TreeNode] = getAncestors(root, q)

		ANCESTORS_P
		.find(
			node =>
				ANCESTORS_Q
				.contains(node)
		) match {
			case Some(node) => node
			case None => throw new IllegalArgumentException("[ERROR]: No common ancestor.")
		}
	}
}


object Maine extends App {
	val root: TreeNode =
		new TreeNode(
			3,
			new TreeNode(
				5,
				new TreeNode(6),
				new TreeNode(
					2,
					new TreeNode(7),
					new TreeNode(4)
				)
			),
			new TreeNode(
				1,
				new TreeNode(0),
				new TreeNode(8)
			)
		)


	Solution.lowestCommonAncestor(root, root.left, root.right)
}