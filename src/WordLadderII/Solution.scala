package WordLadderII


// TOO SLOW
object Solution {

	def listToGraph(beginWord: String, wordList: List[String]): Map[String, List[String]] = {
		def wordToList(word: String, wordList: List[String]): List[String] = {
			def isDistOne(word1: String, word2: String): Boolean = {
				def wordDistance(word1: String, word2: String): Int = {
					if (word1.isEmpty) return word2.length
					if (word2.isEmpty) return word1.length

					if (word1.head != word2.head) 1 + wordDistance(word1.tail, word2.tail)
					else wordDistance(word1.tail, word2.tail)
				}
				wordDistance(word1, word2) == 1
			}
			wordList.foldRight(List(): List[String])(
				(curr, acc) => if (isDistOne(word, curr)) curr :: acc else acc)
		}

		wordList.foldRight(Map(): Map[String, List[String]])(
			(curr: String, acc: Map[String, List[String]]) =>
				acc + (curr -> wordToList(curr, wordList))
		) updated (beginWord, wordToList(beginWord, wordList))
	}

	var paths: List[List[String]] = List()
	def allPaths(currentWord: String,
				 endWord: String,
				 graph: Map[String, List[String]],
				 vis: List[String] = List()): Unit = {

		if (vis contains currentWord) return

		if (currentWord == endWord) {
			paths = (vis :+ endWord) :: paths
			return
		}

		graph.get(currentWord) match {
			case Some(neighs) => {
				for (neigh <- neighs) {
					allPaths(
						neigh,
						endWord,
						graph,
						vis :+ currentWord
					)
				}
			}
			case None => return
		}
	}

	def findLadders(beginWord: String, endWord: String, wordList: List[String]): List[List[String]] = {
		val graph: Map[String, List[String]] = listToGraph(beginWord, wordList)
		allPaths(beginWord, endWord, graph)
		val minLen = paths.foldRight(Int.MaxValue)(
			(curr, acc) => acc.min(curr.length)
		)
		val paths_aux: List[List[String]] = paths.filter(_.length == minLen)
		paths = List()
		paths_aux
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		val beginWord: String = "hit"
		val endWord: String = "cog"
		val wordList: List[String] =
			List(
				"hot", "dot",
				"dog", "lot",
				"log", "cog"
			)
		println(Solution.findLadders(beginWord, endWord, wordList))
	}
}