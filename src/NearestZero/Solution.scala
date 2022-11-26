package NearestZero

object Solution {
	def initFlooded(mat: Array[Array[Int]]): Array[Array[Boolean]] = {
		Array.fill(mat.length)(Array.fill(mat(0).length)(false))
	}

	def initNearest(mat: Array[Array[Int]]): Array[Array[Int]] = {
		Array.fill(mat.length)(Array.fill(mat(0).length)(-1))
	}

	def nearestZeroDist(mat:Array[Array[Int]], i: Int, j: Int, flooded: Array[Array[Boolean]]): Int = {
		if (i > mat.length - 1 || j > mat(0).length - 1 || i < 0 || j < 0) return 10000
		if (flooded(i)(j)) return 10000
		var flooded_copy = flooded.updated(i, flooded(i).updated(j, true))

		if (mat(i)(j) == 0) return 0


		Integer.min(
			Integer.min(
				1 + nearestZeroDist(mat, i + 1, j, flooded_copy),
				1 + nearestZeroDist(mat, i - 1, j, flooded_copy)
			),
			Integer.min(
				1 + nearestZeroDist(mat, i, j - 1, flooded_copy),
				1 + nearestZeroDist(mat, i, j + 1, flooded_copy)
			)
		)
	}
	def updateMatrix(mat: Array[Array[Int]]): Array[Array[Int]] = {
		val res = initNearest(mat)
		for (i <- 0 to (mat.length - 1); j <- 0 to (mat(0).length - 1)) {
			res(i)(j) = nearestZeroDist(mat, i, j, initFlooded(mat))
		}
		res
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		val mat: Array[Array[Int]] =
			Array(
				Array(0, 0, 1, 0, 1, 1, 1, 0, 1, 1),
				Array(1, 1, 1, 1, 0, 1, 1, 1, 1, 1)
			)

		println(Solution.updateMatrix(mat).toList.map(_.toList))
	}
}