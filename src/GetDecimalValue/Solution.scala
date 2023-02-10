package GetDecimalValue

import scala.annotation.tailrec


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
object Solution {
	def getDecimalValue(head: ListNode): Int = {
		@tailrec
		def getBinaryValue(head: ListNode, accBinary: List[Int] = List()): List[Int] = {
			if (head == null) accBinary
			else getBinaryValue(head.next, head.x :: accBinary)
		}


		@tailrec
		def binaryToDecimal(binaryRev: List[Int], currPower: Int = 0, accDecimal: Int = 0): Int = {
			if (binaryRev.isEmpty) accDecimal
			else
				binaryToDecimal(
					binaryRev
					.tail,
					currPower + 1,
					accDecimal +
					binaryRev.head *
					Math
					.pow(
						2,
						currPower
					)
					.toInt
				)

		}


		val BINARY_LIST: List[Int] =
			getBinaryValue(head)

		binaryToDecimal(BINARY_LIST)
	}
}

