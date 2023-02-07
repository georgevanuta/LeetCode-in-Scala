package WordSearch

// https://leetcode.com/problems/word-search/
object Solution {
	def exist(board: Array[Array[Char]], word: String): Boolean = {
		// new vis matrix
		def visMatrix(board: Array[Array[Char]]): Array[Array[Boolean]] = {
			List.fill(board.length)(List.fill(board(0).length)(false).toArray).toArray
		}

		def existAux(
					word: String,
					vis: Array[Array[Boolean]],
					x: Int,
					y: Int
					): Boolean =
		{
			// toggle vis matrix
			def updateVis(): Array[Array[Boolean]] = vis.updated(x, vis(x).updated(y, true))

			if (word.isEmpty) true
			else if (word.head == board(x)(y)) {
				if (word.length == 1)
					true
				else {
					val goUp: Boolean = {
						if (x == 0) false
						else if (vis(x - 1)(y)) false
						else existAux(word.tail, updateVis(), x - 1, y)
					}
					val goDown: Boolean = {
						if (x == board.length - 1) false
						else if (vis(x + 1)(y)) false
						else existAux(word.tail, updateVis(), x + 1, y)
					}
					val goLeft: Boolean = {
						if (y == 0) false
						else if (vis(x)(y - 1)) false
						else existAux(word.tail, updateVis(), x, y - 1)
					}
					val goRight: Boolean = {
						if (y == board(0).length - 1) false
						else if (vis(x)(y + 1)) false
						else existAux(word.tail, updateVis(), x, y + 1)
					}

					goUp || goDown || goLeft || goRight
				}
			}
			else false

		}

		var found: Boolean = false
		for (i <- 0 to (board.length - 1); j <- 0 to (board(0).length - 1)) {
			found = found || existAux(word, visMatrix(board), i, j)
		}
		found
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		val board: Array[Array[Char]] = Array(
			Array('a', 'b', 'c', 'e'),
			Array('s', 'f', 'c', 's'),
			Array('a', 'd', 'e', 'e')
		)
		println(Solution.exist(Array(Array('a', 'a')), "aa"))
	}
}