package Profit

object Solution {
	def maxProfit(prices: Array[Int]): Int = {
		var currMax: Int = 0
		for (i <- 0 to prices.size - 1) {
			val currDay: Int = prices(i)
			for (j <- i to prices.size - 1) {
				currMax = Integer.max(
					currMax,
					prices(j) - currDay
				)
			}
		}

		currMax
	}
}