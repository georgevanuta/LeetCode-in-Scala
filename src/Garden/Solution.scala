package Garden


// https://leetcode.com/problems/flower-planting-with-no-adjacent/
object Solution {
	private final val NO_FLOWER: Int = -1
	private final val ALL_FLOWERS: Set[Int] = Set(1, 2, 3, 4)

	def gardenNoAdj(n: Int, paths: Array[Array[Int]]): Array[Int] = {
		var gardens: Array[Int] = Array.fill(n)(NO_FLOWER)

		def getNeighs(i: Int): Set[Int] = {
			paths.filter(_.contains(i)).map(_.filterNot(_ == i).head).toSet
		}

		def availableFlowers(i: Int): Set[Int] = {
			val flowersOfNeighs: Set[Int] = getNeighs(i + 1).map(n => gardens(n - 1))

			ALL_FLOWERS.diff(flowersOfNeighs)
		}

		for (i <- 0 until n) {
			val pickedFlower: Int = availableFlowers(i).head
			gardens(i) = pickedFlower
		}

		gardens
	}
}


object Main extends App {
	val n: Int = 3
	val l: Array[Array[Int]] = Array(
		Array(1, 2),
		Array(2, 3),
		Array(3, 1)
	)

	println(Solution.gardenNoAdj(n, l).toList)
}