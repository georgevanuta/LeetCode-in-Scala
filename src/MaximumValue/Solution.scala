package MaximumValue


// https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/description/
object Solution {
	def maximumValue(strs: Array[String]): Int = {
		strs
		.map(
			s => if (s.forall(_.isDigit)) s.toInt else s.length
		).max
	}
}
