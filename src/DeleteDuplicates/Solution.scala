package DeleteDuplicates


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
object Solution {
	private final val OUTSIDE_ELEMENT: Int = 101

	def deleteDuplicates(head: ListNode, prev: Int = OUTSIDE_ELEMENT): ListNode = {
		if (head == null) null
		else if (head.x == prev) deleteDuplicates(head.next, prev)
		else new ListNode(head.x, deleteDuplicates(head.next, head.x))
	}
}