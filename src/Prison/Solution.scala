package Prison

// https://leetcode.com/problems/prison-cells-after-n-days/
object Solution {
	private final val NrCells: Int = 8


	def prisonAfterNDays(cells: Array[Int], n: Int): Array[Int] = {
		var cellsBefore: Array[Int] = cells.clone()
		val cellsAfter: Array[Int] = cells.clone()

		def shouldOccupy(i: Int): Boolean = {
			if (i == 0 || i == NrCells - 1) return false
			cellsBefore(i - 1) == cellsBefore(i + 1)
		}

		for (_ <- 0 to (n - 1) % 14) {

			for (i <- 0 to NrCells - 1) {
				if (shouldOccupy(i)) cellsAfter(i) = 1
				else cellsAfter(i) = 0
			}

			cellsBefore = cellsAfter.clone()
		}

		cellsAfter
	}
}

object Main extends App {
	val cells: Array[Int] = Array(0,1,0,1,1,0,0,1)
	val n: Int = 7
	println(Solution.prisonAfterNDays(cells, n).toList)
}