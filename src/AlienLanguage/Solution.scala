package AlienLanguage


// https://leetcode.com/problems/verifying-an-alien-dictionary/
object Solution {
	def compareAlienWords(w1: String, w2: String, order: String): Boolean = {
		for (i <- 0 to Math.min(w1.length, w2.length) - 1) {
			if (order.indexOf(w1(i)) < order.indexOf(w2(i))) return true
			if (order.indexOf(w1(i)) > order.indexOf(w2(i))) return false
		}

		false
	}

	def isAlienSorted(words: Array[String], order: String): Boolean = {
		val wordsSorted: Array[String] =
			words.sortWith((w1, w2) => compareAlienWords(w1, w2, order))

		wordsSorted.sameElements(words)
	}
}


object Main extends App {
	val ws: Array[String] = Array("hello","leetcode")

	val order: String = "hlabcdefgijkmnopqrstuvwxyz"

	Solution.isAlienSorted(ws, order)

}