package CheckValid


// https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
object Solution {
	def checkValid(matrix: Array[Array[Int]]): Boolean = {
		val RANGE: Set[Int] =
			(1 to matrix.length)
			.toSet

		val VALID_LINES: Boolean =
			matrix
			.map(_.toSet)
			.forall(_ == RANGE)

		val VALID_COLUMNS: Boolean =
			RANGE
			.map(
				i =>
					matrix
					.map(
						line => {
							line(i - 1)
						}
					)
					.toSet
			)
			.forall(_ == RANGE)

		VALID_LINES &&
		VALID_COLUMNS
	}
}
