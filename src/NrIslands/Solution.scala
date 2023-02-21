package NrIslands


// https://leetcode.com/problems/number-of-islands/description/
object Solution {
	private final val LAND: Char = '1'
	private final val VIS_LAND: Char = 'x'


	def numIslands(grid: Array[Array[Char]]): Int = {
		val N: Int = grid.length
		val M: Int = grid.head.length

		def visitIsland(i: Int, j: Int): Unit = {
			def isInBounds: Boolean = {
				(i >= 0 && i < N) &&
				(j >= 0 && j < M)
			}

			if (isInBounds && grid(i)(j) == LAND) {
				grid(i)(j) = VIS_LAND
				
				visitIsland(i - 1, j)
				visitIsland(i + 1, j)
				visitIsland(i, j - 1)
				visitIsland(i, j + 1)
			}
		}

		var nrIslands: Int = 0

		(0 until N)
		.foreach(
			i => {
				(0 until M)
				.foreach(
					j => {
						if (grid(i)(j) == LAND) {
							nrIslands += 1
							visitIsland(i, j)
						}
					}
				)
			}
		)

		nrIslands
	}
}
