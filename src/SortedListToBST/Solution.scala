package SortedListToBST

import scala.annotation.tailrec


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
	var value: Int = _value
	var left: TreeNode = _left
	var right: TreeNode = _right
}


// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
object Solution {
	def sortedListToBST(head: ListNode): TreeNode = {
		@tailrec
		def listToArray(head: ListNode, accArray: Array[Int] = Array()): Array[Int] = {
			if (head == null) accArray
			else listToArray(head.next, accArray ++ Array(head.x))
		}


		def sortedArrayToBST(nums: Array[Int]): TreeNode = {
			if (nums.isEmpty) null
			else if (nums.length == 1) new TreeNode(nums.head)
			else {
				val MID: Int = nums.length / 2

				new TreeNode(
					nums(MID),
					sortedArrayToBST(nums.slice(0, MID)),
					sortedArrayToBST(nums.slice(MID + 1, nums.length))
				)
			}
		}


		val ARRAY: Array[Int] = listToArray(head)
		val BST: TreeNode = sortedArrayToBST(ARRAY)

		BST
	}
}