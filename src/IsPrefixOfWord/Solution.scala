package IsPrefixOfWord


// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
object Solution {
	def isPrefixOfWord(sentence: String, searchWord: String): Int = {
		val INDEX: Int =
			sentence
			.split(" ")
			.indexWhere(_.startsWith(searchWord))

		if (INDEX == -1) INDEX
		else INDEX + 1
	}
}
