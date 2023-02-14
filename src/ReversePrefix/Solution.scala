package ReversePrefix


// https://leetcode.com/problems/reverse-prefix-of-word/
object Solution {
	def reversePrefix(word: String, ch: Char): String = {
		val FIRST_INDEX: Int = word.indexOf(ch)

		word
		.slice(
			0,
			FIRST_INDEX
		)
		.reverse ++
		word
		.slice(
			FIRST_INDEX + 1,
			word
			.length
		)
	}
}
