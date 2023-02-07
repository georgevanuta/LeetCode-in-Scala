package SubMat1

import scala.collection.mutable.Stack

object Solution {

	def numSubmat(mat: Array[Array[Int]]): Int = {
		def isAllOne(upperLeft: (Int, Int), lowerRight: (Int, Int)): Boolean = {
			val matPortion: Array[Array[Int]] =
				mat.slice(upperLeft._1, lowerRight._1 + 1)
				   .map(_.slice(upperLeft._2, lowerRight._2 + 1))


			matPortion.forall(_.forall(_ == 1))
		}

		def isMatSubmatOf(upperLeft1: (Int, Int), lowerRight1: (Int, Int),
						  upperLeft2: (Int, Int), lowerRight2: (Int, Int)): Boolean = {

			upperLeft1._1 >= upperLeft2._1 &&
			upperLeft1._2 >= upperLeft2._2 &&
			lowerRight1._1 <= lowerRight2._1 &&
			lowerRight1._2 <= lowerRight2._2
		}


		val foundMats: Stack[((Int, Int), (Int, Int))] = Stack()

		def numSubmatAux(upperLeft: (Int, Int), lowerRight: (Int, Int)): Int = {
			if (upperLeft._1 > lowerRight._1 || upperLeft._2 > lowerRight._2)
				return 0


			if (isAllOne(upperLeft, lowerRight) &&
				!foundMats.exists(x => isMatSubmatOf(upperLeft, lowerRight, x._1, x._2))) {

				foundMats.push((upperLeft, lowerRight))

				val m: Int = lowerRight._1 - upperLeft._1
				val n: Int = lowerRight._2 - upperLeft._2

				val subMatricesCount: Int =
					(m + 1) * (m + 2) * n * (n + 1) / 4 +
					m * (m + 1) * (n + 1) * (n + 2) / 4

				numSubmatAux((upperLeft._1 + 1, upperLeft._2), lowerRight) +
				numSubmatAux((upperLeft._1, upperLeft._2 + 1), lowerRight) +
				numSubmatAux(upperLeft, (lowerRight._1 - 1, lowerRight._2)) +
				numSubmatAux(upperLeft, (lowerRight._1, lowerRight._2 - 1)) +
				subMatricesCount
			}
			else {
				numSubmatAux((upperLeft._1 + 1, upperLeft._2), lowerRight) +
				numSubmatAux((upperLeft._1, upperLeft._2 + 1), lowerRight) +
				numSubmatAux(upperLeft, (lowerRight._1 - 1, lowerRight._2)) +
				numSubmatAux(upperLeft, (lowerRight._1, lowerRight._2 - 1))
			}
		}

		numSubmatAux((0, 0), (mat.length - 1, mat.head.length - 1))
	}
}

object Main extends App {
	val mat = Array(
		Array(1, 1, 1),
		Array(1, 1, 1),
		Array(1, 1, 1)
	)

	println(Solution.numSubmat(mat))
}