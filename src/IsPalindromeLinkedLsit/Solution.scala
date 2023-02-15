package IsPalindromeLinkedLsit

import scala.annotation.tailrec


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/palindrome-linked-list/
object Solution {
	def isPalindrome(head: ListNode): Boolean = {
		@tailrec
		def toString(head: ListNode, accString: String = ""): String = {
			if (head == null) accString
			else toString(head.next, accString ++ head.x.toString)
		}

		val HEAD_STRING: String = toString(head)

		HEAD_STRING == HEAD_STRING.reverse
	}
}
