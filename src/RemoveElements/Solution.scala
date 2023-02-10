package RemoveElements


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/remove-linked-list-elements/
object Solution {
	def removeElements(head: ListNode, `val`: Int): ListNode = {
		if (head == null) null
		else if (head.x == `val`) removeElements(head.next, `val`)
		else new ListNode(head.x, removeElements(head.next, `val`))
	}
}