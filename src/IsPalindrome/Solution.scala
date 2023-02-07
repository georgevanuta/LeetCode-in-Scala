package IsPalindrome

// https://leetcode.com/problems/palindrome-number/
object Solution {
	def isPalindrome(x: Int): Boolean = {
		val xS: String = x.toString
		val halfLen: Int = xS.length / 2

		val firstHalf: String =
			xS.slice(0, halfLen)

		val secondHalf: String =
			xS.reverse.slice(0, halfLen)

		firstHalf == secondHalf
	}
}
