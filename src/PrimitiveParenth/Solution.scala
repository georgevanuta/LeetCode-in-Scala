package PrimitiveParenth

import scala.collection.mutable.Stack

// https://leetcode.com/problems/remove-outermost-parentheses/
object Solution {
	def removeOuterParentheses(s: String): String = {
		var primitives: List[String] = List()

		var didPushOpen: Boolean = false
		var isNonEmpty: Boolean = true

		val parenthStack: Stack[Char] = Stack()
		var currentPrimitve: String = ""

		var untilEnd: Int = 0

		for (ch <- s) {
			if (ch == '(' && !didPushOpen) {
				parenthStack.push('(')
				didPushOpen = true
				currentPrimitve :+= '('
				untilEnd += 1
			}
			else if (ch == '(' && didPushOpen) {
				parenthStack.push('(')
				isNonEmpty = true
				currentPrimitve :+= '('
				untilEnd += 1
			}
			else if (ch == ')' && !isNonEmpty) {
				untilEnd = 0
				currentPrimitve = ""
				didPushOpen = false
				parenthStack.pop()
			}
			else if (ch == ')' && isNonEmpty) {
				currentPrimitve :+= ')'
				untilEnd -= 1
				if (untilEnd == 0) {
					primitives :+= currentPrimitve
					isNonEmpty = false
					didPushOpen = false
					currentPrimitve = ""
				}
			}
		}

		primitives.map(
			x => x.substring(1, x.length - 1)
		).mkString("")
	}
}

object Main extends App {
	val s  = "(()())(())"

	println(Solution.removeOuterParentheses(s))
}