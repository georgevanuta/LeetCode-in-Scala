package EvalRPN


// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
object Solution {
	private final val OPERATORS: Set[String] =
		Set("+", "-", "*", "/")

	private def doOperation(op: String, s1: Int, s2: Int): Int = {
		op match {
			case "+" => s1 + s2
			case "-" => s1 - s2
			case "*" => s1 * s2
			case "/" => s1 / s2
			case _ => throw new IllegalArgumentException("[ERROR]: Operation " ++ op ++ " not supported.")
		}
	}


	def evalRPN(tokens: Array[String], currStack: List[Int] = List()): Int = {
		if (tokens.isEmpty) currStack.head
		else if (OPERATORS.contains(tokens.head)) {
			val s1: Int = currStack.head
			val s2: Int = currStack.tail.head
			val res: Int = doOperation(tokens.head, s2, s1)

			evalRPN(tokens.tail, res :: currStack.tail.tail)
		}
		else evalRPN(tokens.tail, tokens.head.toInt :: currStack)
	}
}
