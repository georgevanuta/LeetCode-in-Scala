package ShortestPoint

// https://leetcode.com/problems/minimum-time-visiting-all-points/
object Solution {
	def shortestBetweenTwoPoints(p1: Array[Int], p2: Array[Int]): Int = {
		var t: Int = 0

		var xDir: Int = p2(0) - p1(0)
		var yDir: Int = p2(1) - p1(1)

		val currentP1: Array[Int] = p1

		while (xDir != 0 && yDir != 0) {
			currentP1(0) += xDir.sign
			xDir -= xDir.sign
			currentP1(1) += yDir.sign
			yDir -= yDir.sign

			t += 1
		}

		t + (Math.abs(xDir) + Math.abs(yDir))
	}

	def minTimeToVisitAllPoints(points: Array[Array[Int]]): Int = {
		if (points.size <= 1) 0
		else {
			val p1: Array[Int] = points(0)
			val p2: Array[Int] = points(1)

			shortestBetweenTwoPoints(p1, p2) +
			minTimeToVisitAllPoints(points.tail)
		}
	}
}


object Main extends App {
	val p1: Array[Int] = Array(-1, 0)
	val p2: Array[Int] = Array(3, 4)

	println(Solution.shortestBetweenTwoPoints(p1, p2))
}