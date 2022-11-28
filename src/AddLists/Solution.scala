package AddLists

class ListNode(_x: Int = 0, _next: ListNode = null) {
 	var next: ListNode = _next
 	var x: Int = _x

}

// https://leetcode.com/problems/add-two-numbers/
object Solution {
	def addTwoNumbers(l1: ListNode, l2: ListNode, carry: Int = 0): ListNode = {
		if (l1 == null && l2 == null && carry == 0) return null
		if (l1 == null && l2 == null && carry != 0) return new ListNode(carry)
		if (l1 == null) return new ListNode((l2.x + carry) / 10, addTwoNumbers(null, l2.next, (l2.x + carry) / 10))
		if (l2 == null) return new ListNode((l1.x + carry) / 10, addTwoNumbers(l1.next, null, (l1.x + carry) / 10))

		val newValue: Int = (l1.x + l2.x + carry) % 10
		val newCarry: Int = (l1.x + l2.x + carry) / 10

		new ListNode(newValue, addTwoNumbers(l1.next, l2.next, newCarry))
	}
}
