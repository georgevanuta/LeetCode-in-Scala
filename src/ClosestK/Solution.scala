package ClosestK

// https://leetcode.com/problems/k-closest-points-to-origin/
object Solution {
	def kClosest(points: Array[Array[Int]], k: Int): Array[Array[Int]] = {
		def calcDist(p: Array[Int]): Double =
			Math.sqrt(Math.pow(p(0), 2) + Math.pow(p(1), 2))

		val distWithIndexSorted: Array[(Double, Int)] =
			points.map(calcDist).zipWithIndex.sortWith((a1, a2) => a1._1 < a2._1)

		val kClosest: Array[Array[Int]] =
			distWithIndexSorted.take(k).map(i => points(i._2))

		kClosest
	}
}