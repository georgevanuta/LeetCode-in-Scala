package SearchMatrix

// https://leetcode.com/problems/search-a-2d-matrix/
object Solution {
	def searchMatrix(matrix: Array[Array[Int]], target: Int, x: Int = 0, y: Int = 0): Boolean = {
		if (matrix(x)(y) == target)
			true
		else if (x == matrix.length && y == matrix(0).length)
			false
		else if (x != matrix.length - 1 && target >= matrix(x + 1)(y))
			searchMatrix(matrix, target, x + 1, y)
		else if (y != matrix(0).length - 1 && target >= matrix(x)(y + 1))
			searchMatrix(matrix, target, x, y + 1)
		else
			false
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		val matrix: Array[Array[Int]] = Array(
			Array(1, 3, 5, 7),
			Array(10, 11, 16, 20),
			Array(23, 30, 34, 60)
		)
		println(Solution.searchMatrix(matrix, 22))
	}
}