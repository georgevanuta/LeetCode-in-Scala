package IsPowerOf4


// https://leetcode.com/problems/power-of-four/description/
object Solution {
	def isPowerOfFour(n: Int): Boolean = {
		if (n == 1) true
		else if (n % 4 != 0) false
		else if (n < 1) false
		else isPowerOfFour(n / 4)
	}
}
