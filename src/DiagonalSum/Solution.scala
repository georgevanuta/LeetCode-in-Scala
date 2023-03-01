package DiagonalSum


// https://leetcode.com/problems/matrix-diagonal-sum/
object Solution {
	def diagonalSum(mat: Array[Array[Int]]): Int = {
		val MAT_LENGTH: Int = mat.length - 1

		def getFirstDiagonal: IndexedSeq[Int] = {
			mat
			.indices
			.map(i => mat(i)(i))
		}

		def getSecondDiagonal: IndexedSeq[Int] = {

			mat
			.indices
			.map(
				i => mat(i)(MAT_LENGTH - i)
			)
		}

		def getMiddleElement: Int = {
			if (MAT_LENGTH % 2 == 0) {
				val MIDDLE_INDEX: Int = MAT_LENGTH / 2
				mat(MIDDLE_INDEX)(MIDDLE_INDEX)
			} else 0 // not existent
		}

		(getFirstDiagonal ++ getSecondDiagonal)
		.sum - getMiddleElement
	}
}
