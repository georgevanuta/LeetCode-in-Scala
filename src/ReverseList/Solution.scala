package ReverseList


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/reverse-linked-list/description/
object Solution {
	def reverseList(head: ListNode, acc: ListNode = null): ListNode = {
		if (head == null) acc
		else reverseList(head.next, new ListNode(head.x, acc))
	}
}
