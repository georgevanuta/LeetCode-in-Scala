package LongestPalindrome


// 5. Longest Palindromic Substring
object Solution {
	def longestPalindrome(s: String): String = {
		val n: Int = s.length
		val a: Array[Array[Boolean]] = Array.ofDim(n, n)
		var maxL: Int = 1

		(0 until n).foreach(i => a(i)(i) = true)

		var st: Int = 0
		for (i <- 0 until n - 1) {
			if (s(i) == s(i + 1)) {
				a(i)(i + 1) = true
				st = i
				maxL = 2
			}
		}

		for (k <- 3 to n) {
			for (i <- 0 to n - k) {
				val j: Int = i + k - 1

				if (a(i + 1)(j - 1) && s(i) == s(j)) {
					a(i)(j) = true

					if (k > maxL) {
						st = i
						maxL = k
					}
				}
			}
		}

		s.substring(st, st + maxL - 1)
	}
}