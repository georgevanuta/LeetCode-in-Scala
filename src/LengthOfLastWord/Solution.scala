package LengthOfLastWord

// https://leetcode.com/problems/length-of-last-word/description/
object Solution {
	def lengthOfLastWord(s: String): Int = {
		s.split(" ").last.length
	}
}
