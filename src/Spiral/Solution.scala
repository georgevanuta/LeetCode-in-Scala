package Spiral

// https://leetcode.com/problems/spiral-matrix-ii/
object Solution {
	def generateMatrix(n: Int): Array[Array[Int]] = {
		var mat: Array[Array[Int]] = Array.ofDim(n, n)

		var currVal: Int = 1
		var currLine: Int = 0
		var currCol: Int = 0
		var currMaxLine: Int = n
		var currMaxCol: Int = n

		while (currLine < currMaxLine && currCol < currMaxCol) {
			for (i <- currCol until currMaxCol) {
				mat(currLine)(i) = currVal
				currVal += 1
			}

			currLine += 1

			for (i <- currLine until currMaxLine) {
				mat(i)(currMaxLine - 1) = currVal
				currVal += 1
			}

			currMaxCol -= 1

			if (currLine < currMaxLine) {
				for (i <- (currCol until currMaxCol).reverse) {
					mat(currMaxLine - 1)(i) = currVal
					currVal += 1
				}

				currMaxLine -= 1
			}

			if (currCol < currMaxCol) {
				for (i <- (currLine until currMaxLine).reverse) {
					mat(i)(currCol) = currVal
					currVal += 1
				}
				currCol += 1
			}
		}

		mat
	}
}