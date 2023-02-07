package IsCircularSentence


// https://leetcode.com/problems/circular-sentence/description/
object Solution {
	def isCircularSentence(sentence: String): Boolean = {

		val firstAndLastLetters: Array[String] =
			sentence
			.split(" ")
			.map(word => word.head.toString ++ word.last.toString)

		var acc: String = firstAndLastLetters.head

		for (el <- firstAndLastLetters.tail) {
			if (el.head != acc.last) return false
			acc = el
		}

		firstAndLastLetters.head.head == firstAndLastLetters.last.last
	}
}


object Main extends App {
	val s: String = "leetcode exercises sound delightful"

	Solution.isCircularSentence(s)
}