package IsPowerOfThree


// https://leetcode.com/problems/power-of-three/description/
object Solution {
	def isPowerOfThree(n: Int): Boolean = {
		if (n == 1) true
		else if (n < 1) false
		else if (n % 3 != 0) false
		else isPowerOfThree(n / 3)
	}
}
