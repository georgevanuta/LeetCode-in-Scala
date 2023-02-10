package NextLargerNode

import scala.annotation.tailrec


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/next-greater-node-in-linked-list/
object Solution {
	def nextLargerNodes(head: ListNode): Array[Int] = {
		@tailrec
		def getGreater(head: ListNode, ref: Int): Int = {
			if (head == null) 0
			else if (head.x > ref) head.x
			else getGreater(head.next, ref)
		}


		if (head == null) Array()
		else Array(getGreater(head, head.x)) ++ nextLargerNodes(head.next)
	}
}
