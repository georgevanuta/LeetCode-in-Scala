package PowerOfTwo

// https://leetcode.com/problems/power-of-two/
object Solution {
	def isPowerOfTwo(n: Int): Boolean = {
		if (n == 1) true
		else if (n % 2 != 0 || n < 1) false
		else isPowerOfTwo(n / 2)
	}
}