package DeleteMiddle

import scala.annotation.tailrec


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
object Solution {
	def deleteMiddle(head: ListNode): ListNode = {
		@tailrec
		def len(head: ListNode, accLen: Int = 0): Int = {
			if (head == null) accLen
			else len(head.next, 1 + accLen)
		}

		def skip(head: ListNode, nr: Int, currIndex: Int = 0): ListNode = {
			if (head == null) null
			else if (nr == currIndex) head.next
			else new ListNode(head.x, skip(head.next, nr, currIndex + 1))
		}

		val LEN: Int = len(head)
		val MIDDLE_INDEX: Int = LEN / 2

		skip(head, MIDDLE_INDEX)
	}
}
