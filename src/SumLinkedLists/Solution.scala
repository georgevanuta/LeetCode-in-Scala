package SumLinkedLists


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
 	var x: Int = _x
}


// https://leetcode.com/problems/add-two-numbers-ii/
object Solution {
	def reverseLinkedList(l: ListNode, acc: ListNode = null): ListNode = {
		if (l == null) return acc

		reverseLinkedList(l.next, new ListNode(l.x, acc))
	}

	def addTwoAux(l1: ListNode, l2: ListNode, carry: Int = 0): ListNode = {
		if (l1 == null && l2 == null && carry == 0) return null

		if (l1 == null && l2 == null) {
			return new ListNode(carry, null)
		}

		if (l1 == null) {
			val sum: Int = (l2.x + carry) % 10
			val newCarry: Int = (l2.x + carry) / 10

			return new ListNode(sum, addTwoAux(null, l2.next, newCarry))
		}

		if (l2 == null) {
			val sum: Int = (l1.x + carry) % 10
			val newCarry: Int = (l1.x + carry) / 10

			return new ListNode(sum, addTwoAux(l1.next, null, newCarry))
		}

		val sum: Int = (l1.x + l2.x + carry) % 10
		val newCarry: Int = (l1.x + l2.x + carry) / 10

		new ListNode(sum, addTwoAux(l1.next, l2.next, newCarry))
	}

	def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
		reverseLinkedList(
			addTwoAux(
				reverseLinkedList(l1),
				reverseLinkedList(l2)
			)
		)
	}
}