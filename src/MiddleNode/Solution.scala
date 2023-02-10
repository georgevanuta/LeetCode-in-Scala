package MiddleNode

import scala.annotation.tailrec


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/middle-of-the-linked-list/
object Solution {


	def middleNode(head: ListNode): ListNode = {
		@tailrec
		def len(head: ListNode, currLen: Int = 0): Int = {
			if (head == null) currLen
			else len(head.next, currLen + 1)
		}

		@tailrec
		def atIndex(head: ListNode, index: Int, currIndex: Int = 0): ListNode = {
			if (head == null) null
			else if (index == currIndex) head
			else atIndex(head.next, index, currIndex + 1)
		}

		val LENGTH: Int = len(head)
		val INDEX: Int = LENGTH / 2


		atIndex(head, INDEX)
	}
}
