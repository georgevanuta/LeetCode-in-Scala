package LongestCommonPrefix


// https://leetcode.com/problems/longest-common-prefix/description/
object Solution {
	def longestCommonPrefix(strs: Array[String]): String = {
		if (strs.exists(_.isEmpty)) ""
		else if (strs.map(_.head).forall(_ == strs.head.head))
			strs.head.head.toString ++ longestCommonPrefix(strs.map(_.tail))
		else ""
	}
}