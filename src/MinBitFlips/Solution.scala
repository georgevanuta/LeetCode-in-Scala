package MinBitFlips


// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
object Solution {
	def minBitFlips(start: Int, goal: Int): Int = {
		val startBinary: String =
			start.toBinaryString

		val goalBinary: String =
			goal.toBinaryString


		val paddedAmounts: List[Int] =
			List(startBinary, goalBinary)
			.map(_.length)
			.map(
				l =>
					List(startBinary, goalBinary)
					.map(_.length)
					.max -
					l
			)

		def padBinary(binary: String, nrZeros: Int): String = {
			List
			.fill(nrZeros){"0"}
			.mkString("")
			.repeat(nrZeros) ++
			binary
		}

		val startPadded: String = padBinary(startBinary, paddedAmounts.head)
		val goalPadded: String = padBinary(goalBinary, paddedAmounts.last)

		startPadded
		.zip(goalPadded)
		.count(pr => pr._1 != pr._2)
	}
}
