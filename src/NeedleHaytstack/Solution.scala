package NeedleHaytstack

import scala.annotation.tailrec


// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
object Solution {
	@tailrec
	def strStr(haystack: String, needle: String, currIndex: Int = 0): Int = {
		if (haystack.isEmpty) -1
		else if (haystack.startsWith(needle)) currIndex
		else strStr(haystack.tail, needle, currIndex + 1)
	}
}