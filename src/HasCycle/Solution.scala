package HasCycle

class ListNode(var _x: Int = 0) {
	var next: ListNode = null
	var x: Int = _x
}


// https://leetcode.com/problems/linked-list-cycle/
object Solution {
	def hasCycle(head: ListNode, nodes: List[ListNode]): Boolean = {
		if (head == null) false
		else if (nodes.contains(head)) true
		else hasCycle(head.next, head::nodes)
	}
}
