package TwoSumBT

import scala.collection.mutable.HashMap


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
object Solution {
	def findTarget(root: TreeNode, k: Int): Boolean = {
		val sumMap: HashMap[Int, Int] = HashMap()

		def recurse(r: TreeNode): Boolean = {
			if (r == null) false
			else {
				sumMap.get(k - r.value) match {
					case Some(_) => true
					case None => {
						sumMap.update(r.value, 0)

						recurse(r.left) || recurse(r.right)
					}
				}
			}
		}

		recurse(root)
	}
}