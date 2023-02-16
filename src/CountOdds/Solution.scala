package CountOdds


// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/
object Solution {
	def countOdds(low: Int, high: Int): Int = {
		(
		(high + high % 2) -
		(low - low % 2)
		) / 2
	}
}
