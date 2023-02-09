package NaryTreePreorderTraversal


class Node(var _value: Int) {
	var value: Int = _value
	var children: List[Node] = List()
}


// https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
object Solution {
	def preorder(root: Node): List[Int] = {
		if (root == null) List()
		else
			List(root.value) ++
			root
			.children
			.foldRight(List[Int]())(
				(curr, acc) => {
					preorder(curr) ++ acc
				}
			)
	}
}
