package RollsToTarget

// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
object Solution {
	def moduloRes(res: Int): Int = res % 1_000_000_007

	def numRollsToTarget(n: Int, k: Int, target: Int): Int = {
		var dp: Array[Int] = Array.fill(target + 1)(0)
		dp = dp.updated(0, 1)

		for (i <- 1 to n) {
			var aux: Array[Int] = Array.fill(target + 1)(0)

			for (j <- 1 to target) {
				if (j <= i * k) {

					for (l <- 1 to Math.min(j, k)) {
						aux = aux.updated(j, moduloRes(aux(j) + dp(j - l)))
					}

				}
			}

			dp = aux
		}

		println(dp.toList)
		dp(target)
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		Solution.numRollsToTarget(3, 6, 3)
	}
}