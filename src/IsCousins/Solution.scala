package IsCousins


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/cousins-in-binary-tree/
object Solution {
	def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
		def getDepth(r: TreeNode, el: Int): Int = {
			if (r == null) Integer.MIN_VALUE
			else if (r.value == el) 0
			else 1 + Math.max(getDepth(r.left, el), getDepth(r.right, el))
		}

		def getParent(r: TreeNode, el: Int, currParent: Int = -1): Int = {
			if (r == null) 0
			else if (r.value == el) currParent
			else getParent(r.left, el, r.value) + getParent(r.right, el, r.value)
		}

		val (xDepth, xParent): (Int, Int) = (getDepth(root, x), getParent(root, x))
		val (yDepth, yParent): (Int, Int) = (getDepth(root, y), getParent(root, y))

		(xDepth == yDepth) && (xParent != yParent)
	}
}