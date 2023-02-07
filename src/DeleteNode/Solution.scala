package DeleteNode

class ListNode(var _x: Int = 0) {
	var next: ListNode = null
	var x: Int = _x
}

// https://leetcode.com/problems/delete-node-in-a-linked-list/
object Solution {
	def deleteNode(node: ListNode): Unit = {
		val next: ListNode = node.next
		node.x = next.x
		node.next = next.next
	}
}