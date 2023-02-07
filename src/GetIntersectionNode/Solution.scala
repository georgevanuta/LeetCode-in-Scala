package GetIntersectionNode


class ListNode(var _x: Int = 0) {
	var next: ListNode = null
	var x: Int = _x
}


// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
object Solution {
	def getIntersectionNode(headA: ListNode, headB: ListNode, currNodes: Set[ListNode] = Set()): ListNode = {
		if (headA == null && headB == null) null
		else if (headA == null) {
			if (currNodes.contains(headB)) headB
			else getIntersectionNode(headA, headB.next, currNodes + headB)
		}
		else if (headB == null) {
			if (currNodes.contains(headA)) headA
			else getIntersectionNode(headA.next, headB, currNodes + headA)
		}
		else if (currNodes.contains(headA)) headA
		else if (currNodes.contains(headB)) headB
		else if (headA == headB) headA
		else getIntersectionNode(headA.next, headB.next, currNodes + headA + headB)
	}
}