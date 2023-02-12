package CountEven


// https://leetcode.com/problems/count-integers-with-even-digit-sum/description/
object Solution {
	def countEven(num: Int): Int = {
		(1 to num)
		.count(
			nr => {
				val SUM: Int =
					nr
					.toString
					.split("")
					.map(_.toInt)
					.sum

				SUM % 2 == 0
			}
		)
	}
}
