package CheckInclusion

object Solution {
	def checkInclusion(s1: String, s2: String): Boolean = {
		val wordLength: Int = s1.length
		val sSorted1: Array[Char] = s1.toCharArray.sorted

		for (i <- 0 to s2.length - wordLength) {
			val searchDomain: Array[Char] = s2.substring(i, i + wordLength).toCharArray.sorted
			if (sSorted1.sameElements(searchDomain)) return true
		}

		false
	}
}

object Main extends App {
	val s1 = "ab"
	val s2 = "eidbaooo"

	println(Solution.checkInclusion(s1, s2))
}