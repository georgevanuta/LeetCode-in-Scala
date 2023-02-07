package ListNode


case class ListNode(_x: Int = 0, _next: ListNode = null) {
	var x: Int = _x
	var next: ListNode = _next
}

// https://leetcode.com/problems/add-two-numbers/
object Solution {
	def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
		def addAux(l1: ListNode, l2: ListNode, carry: Int = 0): ListNode = {
			(l1, l2) match {
				case (null, null) =>
					if (carry == 0) null else ListNode(carry, null)
				case (_, null) =>
					ListNode((l1.x + carry) % 10, addAux(l1.next, null, (l1.x + carry) / 10))
				case (null, _) =>
					ListNode((l2.x + carry) % 10, addAux(null, l2.next, (l2.x + carry) / 10))
				case _		   =>
					ListNode((l1.x + l2.x + carry) % 10, addAux(l1.next, l2.next, ((l1.x + l2.x + carry) / 10)))
			}
		}
		addAux(l1, l2)
	}

	def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
		(list1, list2) match {
			case (_, null) => list1
			case (null, _) => list2
			case _		  =>
				if (list1.x < list2.x)
					ListNode(list1.x, mergeTwoLists(list1.next, list2))
				else
					ListNode(list2.x, mergeTwoLists(list1, list2.next))
		}
	}

}

