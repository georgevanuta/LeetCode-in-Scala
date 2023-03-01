package GoalParser


// https://leetcode.com/problems/goal-parser-interpretation/
object Solution {
	def interpret(command: String): String = {
		command
		.replace("()", "o")
		.replace("(al)", "al")
	}
}
