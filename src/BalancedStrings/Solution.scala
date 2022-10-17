package BalancedStrings

// https://leetcode.com/problems/split-a-string-in-balanced-strings/
object Solution {
	def balancedStringSplit(s: String): Int = {
		def searchAux(s: String, nrL: Int = 0, nrR: Int = 0): Int = {
			if (nrL != 0 && nrR != 0 && nrR == nrL) return 1 + searchAux(s)
			if (s.isEmpty) return 0
			if (s.head == 'R') searchAux(s.tail, nrL, nrR + 1)
			else searchAux(s.tail, nrL + 1, nrR)
		}
		searchAux(s)
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		println(Solution.balancedStringSplit("RLRRLLRLRL"))
	}
}