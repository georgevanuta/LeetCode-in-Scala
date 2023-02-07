package ReverseVowel


// https://leetcode.com/problems/reverse-vowels-of-a-string/
object Solution {
	def reverseVowels(s: String): String = {
		def isVowel(c: Char): Boolean = {
			List('a', 'e', 'i', 'o', 'u').contains(c.toLower)
		}

		def getVowels: String = s.filter(isVowel)

		var revVowels: String = getVowels.reverse

		var revS: String = ""
		for (c <- s) {
			if (!isVowel(c)) revS :+= c
			else {
				revS :+= revVowels.head
				revVowels = revVowels.tail
			}
		}

		revS
	}
}