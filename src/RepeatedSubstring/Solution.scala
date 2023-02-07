package RepeatedSubstring

// https://leetcode.com/problems/repeated-substring-pattern/
object Solution {
	def repeatedSubstringPattern(s: String): Boolean = {
		for (i <- (1 to s.size / 2)) {
			val subs: String = s.substring(0, i)

			if (subs * (s.size / i) == s) return true

		}

		false
	}

}

object Main {
	def main(args: Array[String]): Unit = {
		val s = "abab"

		println(Solution.repeatedSubstringPattern(s))
	}
}