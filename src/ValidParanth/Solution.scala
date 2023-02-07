package ValidParanth

import scala.collection.mutable.Stack

// https://leetcode.com/problems/valid-parentheses/
object Solution {
	def isValid(s: String): Boolean = {
		def matchesParan(open: Char, closed: Char) = {
			(open, closed) match {
				case ('(', ')') => true
				case ('[', ']') => true
				case ('{', '}') => true
				case _			=> false
			}
		}

		var stack: Stack[Char] = Stack()
		var valid = true

		for (c <- s) {
			if (List('{', '[', '(').contains(c)) {
				stack.push(c)
			} else {
				if (stack.isEmpty) {
					valid = false
				} else {
					var open: Char = stack.pop()
					valid = valid && matchesParan(open, c)
				}
			}
		}
		valid && stack.isEmpty
	}
}

object Main {
	def main(args: Array[String]) = {
		println(Solution.isValid("()"))
	}
}