package DeleteGreatestValue


// https://leetcode.com/problems/delete-greatest-value-in-each-row/description/
object Solution {
	def deleteGreatestValue(grid: Array[Array[Int]]): Int = {
		if (grid.exists(_.isEmpty)) 0
		else {
			val rowMax: Array[Int] =
				grid
				.map(_.max)

			rowMax.max +
			deleteGreatestValue(
				grid
				.zipWithIndex
				.map(
					pr => {
						val firstIndex: Int =
							pr
							._1
							.indexWhere(_ == rowMax(pr._2))

						pr
						._1
						.zipWithIndex
						.filterNot(_._2 == firstIndex)
						.map(_._1)
					}
				)
			)

		}
	}
}