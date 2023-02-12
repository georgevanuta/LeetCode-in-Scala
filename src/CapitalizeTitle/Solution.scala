package CapitalizeTitle


// https://leetcode.com/problems/capitalize-the-title/
object Solution {
	def capitalizeTitle(title: String): String = {
		title
		.split(" ")
		.map(
			word => {
				if (word.length <= 2) word.toLowerCase
				else word.toLowerCase.capitalize
			}
		)
		.mkString(" ")
	}
}
