package GenerateParenthesis

// https://leetcode.com/problems/generate-parentheses/
object Solution {
	def generateParenthesis(n: Int): List[String] = {
		var all: List[String] = List()
		def generateParenthesisAux(validParanth: String, closed: Int, opened: Int): Unit = {
			if (closed == n && opened == n) {
				all = validParanth :: all
				return
			}

			if (opened < n) generateParenthesisAux(validParanth + "(", closed, opened + 1)

			if (closed < opened) generateParenthesisAux(validParanth + ")", closed + 1, opened)
		}
		generateParenthesisAux("", 0, 0)
		all
	}
}


object Main {
	def main(args: Array[String]): Unit = {
		println(Solution.generateParenthesis(3))
	}
}