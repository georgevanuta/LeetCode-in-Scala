package MergeLinkedLists

import scala.annotation.tailrec


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/merge-in-between-linked-lists/
object Solution {
	def mergeInBetween(list1: ListNode, a: Int, b: Int, list2: ListNode): ListNode = {
		def concat(l1: ListNode, l2: ListNode): ListNode = {
			if (l1 == null) l2
			else new ListNode(l1.x, concat(l1.next, l2))
		}

		def take(l: ListNode, nr: Int, curr: Int = 0): ListNode = {
			if (l == null) null
			else if (curr == nr) null
			else new ListNode(l.x, take(l.next, nr, curr + 1))
		}

		@tailrec
		def drop(l: ListNode, nr: Int, curr: Int = 0): ListNode = {
			if (l == null) null
			else if (curr == nr) l
			else drop(l.next, nr, curr + 1)
		}

		val FIRST_PART: ListNode = take(list1, a)
		val LAST_PART: ListNode = drop(list1, b + 1)

		concat(
			concat(
				FIRST_PART,
				list2
			),
			LAST_PART
		)
	}
}
