package GetRandom


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/linked-list-random-node/
class Solution(_head: ListNode) {

	def getRandom(): Int = {
		def toList(head: ListNode): List[Int] = {
			if (head == null) List()
			else head.x :: toList(head.next)
		}

		import scala.util.Random

		Random.shuffle(toList(_head)).head
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(head)
 * var param_1 = obj.getRandom()
 */