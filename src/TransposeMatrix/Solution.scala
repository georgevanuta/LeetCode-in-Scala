package TransposeMatrix


// https://leetcode.com/problems/transpose-matrix/
object Solution {
	private type Matrix = Array[Array[Int]]


	def transpose(matrix: Matrix, accMatrix: Matrix = Array()): Matrix = {
		if (matrix.exists(_.isEmpty)) accMatrix
		else transpose(matrix.map(_.tail), accMatrix ++ Array(matrix.map(_.head)))
	}
}
