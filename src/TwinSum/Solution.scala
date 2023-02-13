package TwinSum

import scala.annotation.tailrec


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
object Solution {
	def pairSum(head: ListNode): Int = {
		@tailrec
		def reverseList(head: ListNode, accList: ListNode = null): ListNode = {
			if (head == null) accList
			else reverseList(head.next, new ListNode(head.x, accList))
		}

		@tailrec
		def len(head: ListNode, accLen: Int = 0): Int = {
			if (head == null) accLen
			else len(head.next, 1 + accLen)
		}

		@tailrec
		def dropKeep(head: ListNode, nr: Int, currNr: Int = 0, accList: ListNode = null): ListNode = {
			if (head == null) accList
			else if (nr == currNr) accList
			else dropKeep(head.next, nr, currNr + 1, new ListNode(head.x, accList))
		}

		@tailrec
		def maxSum(l1: ListNode, l2: ListNode, currMax: Int = Int.MinValue): Int = {
			if (l1 == null || l2 == null) currMax
			else maxSum(l1.next, l2.next, Math.max(currMax, l1.x + l2.x))
		}

		val LEN: Int = len(head)
		val REV_LIST: ListNode = reverseList(head)
		val REV_HALF: ListNode = dropKeep(head, LEN / 2)
		val FIRST_HALF: ListNode = dropKeep(REV_LIST, LEN / 2)

		maxSum(REV_HALF, FIRST_HALF)
	}
}
