package BSTIterator

import scala.collection.mutable


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/binary-search-tree-iterator/
class BSTIterator(_root: TreeNode) {
	private val INTERIOR_STACK: mutable.Stack[Int] =
		mutable.Stack()
		.pushAll(
			reverseInorder(
				_root
			)
		)

	private def reverseInorder(root: TreeNode): List[Int] = {
		if (root == null) List()
		else
			reverseInorder(root.right) ++
			List(root.value) ++
			reverseInorder(root.left)
	}


	def next(): Int = {
		INTERIOR_STACK.pop()
	}

	def hasNext(): Boolean = {
		INTERIOR_STACK.nonEmpty
	}

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
