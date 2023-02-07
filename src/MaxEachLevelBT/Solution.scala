package MaxEachLevelBT

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
 	var left: TreeNode = _left
 	var right: TreeNode = _right
}

// https://leetcode.com/problems/find-largest-value-in-each-tree-row/
object Solution {
	def largestValues(root: TreeNode): List[Int] = {

		def getLevel(r: TreeNode, level: Int, currLevel: Int = 0): List[Int] = {
			if (r == null) List()
			else if (level == currLevel) List(r.value)
			else getLevel(r.left, level, currLevel + 1) ++ getLevel(r.right, level, currLevel + 1)
		}


		def height(r: TreeNode): Int = {
			if (r == null) 0
			else 1 + Integer.max(
				height(r.left),
				height(r.right)
			)
		}

		val h: Int = height(root)
		(0 until h).map(l => getLevel(root, l).max).toList
	}
}