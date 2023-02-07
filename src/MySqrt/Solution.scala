package MySqrt


// https://leetcode.com/problems/sqrtx/description/
object Solution {
	def mySqrt(x: Int): Int = {
		def aux(low: Int = 1, high: Int = x): Int = {
			if (low > high) high
			else {
				val mid: Int = (low + high) / 2

				if (x / mid == mid) mid
				else if (mid > x / mid) aux(low, mid - 1)
				else aux(mid + 1, high)
			}
		}

		aux()
	}
}


object Main extends App {
	println(Solution.mySqrt(4))
}