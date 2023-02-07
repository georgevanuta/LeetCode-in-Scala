package CommonLetters

// https://leetcode.com/problems/find-common-characters
object Solution {
	def commonChars(words: Array[String]): List[String] = {
		def getLetters(word: String): Array[String] = {
			word.split("")
		}

		if (words.isEmpty) return List()

		words.tail.foldRight(getLetters(words.head))((curr: String, acc: Array[String]) =>
				acc.intersect(getLetters(curr)))
		.toList
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		println(Solution.commonChars(Array("bella","label","roller")))
	}
}