package AlternatingDigitSum


// https://leetcode.com/problems/alternating-digit-sum/description/
object Solution {
	def alternateDigitSum(n: Int): Int = {
		n
		.toString
		.split("")
		.map(_.toInt)
		.zipWithIndex
		.foldRight(0)(
			(curr, acc) => {
				val sign: Int =
					if (curr._2 % 2 == 0) 1 else -1

				acc + curr._1 * sign
			}
		)
	}
}


