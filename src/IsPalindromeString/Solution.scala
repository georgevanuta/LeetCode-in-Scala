package IsPalindromeString


// https://leetcode.com/problems/valid-palindrome/
object Solution {
	def isPalindrome(s: String): Boolean = {
		val curatedString: String =
			s.filter(_.isLetterOrDigit).map(_.toLower)

		val firstHalf: String = curatedString.slice(0, curatedString.length / 2)
		val secondHalfRev: String = curatedString.reverse.slice(0, curatedString.length / 2)

		firstHalf == secondHalfRev
	}
}