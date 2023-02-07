package AddBinary

// https://leetcode.com/problems/add-binary
object Solution {
	def addBinary(a: String, b: String, carry: Int = 0): String = {
		val lastTail: (String => String) = (s: String) => s.reverse.tail.reverse

		if (a.isEmpty && b.isEmpty) {
			if (carry == 0) return ""
			else return "1"
		}

		val lastA: Int = if (a.isEmpty) 0 else Integer.parseInt(a.last.toString)
		val lastB: Int = if (b.isEmpty) 0 else Integer.parseInt(b.last.toString)

		val currentValue: Int = (lastA + lastB + carry) % 2
		val currentCarry: Int = (lastA + lastB + carry) / 2

		addBinary(lastTail(a), lastTail(b), currentCarry) :+ currentValue.toString.head
	}
}

object Main extends App {
	val b1: String = "0"
	val b2: String = "0"

	println(Solution.addBinary(b1, b2))
}
