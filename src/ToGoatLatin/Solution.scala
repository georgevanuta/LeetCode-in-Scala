package ToGoatLatin


// https://leetcode.com/problems/goat-latin/
object Solution {
	private final val VOWELS: List[Char] =
		List('a', 'e', 'i', 'o', 'u')

	def toGoatLatin(sentence: String): String = {
		def toGoatLatinWord(word: String, nrAs: Int): String = {
			if (VOWELS contains word.head.toLower) {
				word + "ma" + ("a" * nrAs)
			}
			else {
				word.tail + word.head.toString + "ma" + ("a" * nrAs)
			}
		}

		sentence.split(" ").zipWithIndex.map(pr => toGoatLatinWord(pr._1, pr._2 + 1)).mkString(" ")
	}
}
