package OddEvenList


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/odd-even-linked-list/
object Solution {
	def oddEvenList(head: ListNode): ListNode = {
		def getEvens(head: ListNode): ListNode = {
			if (head == null) null
			else if (head.next == null) new ListNode(head.x)
			else new ListNode(head.x, getEvens(head.next.next))
		}

		def concat(l1: ListNode, l2: ListNode): ListNode = {
			if (l1 == null) l2
			else new ListNode(l1.x, concat(l1.next, l2))
		}


		val ODDS: ListNode = getEvens(head)
		val EVENS: ListNode = if (head == null) null else getEvens(head.next)

		concat(ODDS, EVENS)
	}
}