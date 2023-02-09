package CountSegments


// https://leetcode.com/problems/number-of-segments-in-a-string/
object Solution {
	def countSegments(s: String): Int = {
		if (s.trim.isEmpty) return 0

		" +"
		.r
		.split(
			s
			.trim
		)
		.length
	}
}
