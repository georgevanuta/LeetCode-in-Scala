package RotateShift

// https://leetcode.com/problems/rotate-string/
object Solution {
	def rotateString(s: String, goal: String, nr: Int = 0): Boolean = {
		if (nr == s.length) false
		else if (s == goal) true
		else rotateString(s.tail ++ s.head.toString, goal, nr + 1)
	}
}