package Postorder


class Node(var _value: Int) {
	var value: Int = _value
	var children: List[Node] = List()
}


// https://leetcode.com/problems/n-ary-tree-postorder-traversal/
object Solution {
	def postorder(root: Node): List[Int] = {
		if (root == null) List()
		else if (root.children.isEmpty) List(root.value)
		else
			root.children.foldRight(List[Int]())(
				(curr, acc) => {
					postorder(curr) ++ acc
				}
			) ++ List(root.value)
	}
}