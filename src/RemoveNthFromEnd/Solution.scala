package RemoveNthFromEnd

import scala.annotation.tailrec


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
object Solution {
	def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
		@tailrec
		def len(head: ListNode, accLen: Int = 0): Int = {
			if (head == null) accLen
			else len(head.next, 1 + accLen)
		}

		val LENGTH: Int = len(head)
		val INDEX: Int = LENGTH - n

		def remove(head: ListNode, currIndex: Int = 0): ListNode = {
			if (head == null) null
			else if (currIndex == INDEX) remove(head.next, currIndex + 1)
			else new ListNode(head.x, remove(head.next, currIndex + 1))
		}

		remove(head)
	}
}