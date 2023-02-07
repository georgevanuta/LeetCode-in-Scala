package RomanToInt

import scala.collection.immutable.HashMap


// https://leetcode.com/problems/roman-to-integer/
object Solution {
	private val converter: HashMap[Char, Int] =
		HashMap[Char, Int](
			'I' -> 1,
			'V' -> 5,
			'X' -> 10,
			'L' ->  50,
			'C' -> 100,
			'D' -> 500,
			'M' -> 1000
		)


	def romanToInt(s: String): Int = {
		var res: Int = 0



		for (i <- 0 to s.size - 1) {
			val first: Int = converter.getOrElse(s(i), -1)

			if (i < s.size - 1) {
				val second: Int = converter.getOrElse(s(i + 1), -1)

				if (first >= second) res += first
				else res -= first
			}
			else res += first
		}

		res
	}
}