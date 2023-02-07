package ConvertToBase7


// https://leetcode.com/problems/base-7/
object Solution {
	def convertToBase7(num: Int): String = {
		var absNum: Int = Math.abs(num)
		var sign: Int = num / absNum
		var base7: String = if (sign < 0) "-" else ""
		var currNum: Int = absNum




		base7
	}
}