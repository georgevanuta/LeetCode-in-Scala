package ReverseString


// https://leetcode.com/problems/reverse-string/
object Solution {
	def reverseString(s: Array[Char]): Unit = {
		for (i <- 0 to s.length / 2 - 1) {
			val aux: Char = s(i)
			s(i) = s(s.length - 1 - i)
			s(s.length - 1 - i) = aux
		}
	}
}