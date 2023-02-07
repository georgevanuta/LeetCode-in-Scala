package Cities

import scala.collection.mutable.Queue

object Solution {

	def shouldInclude(
					 isConnected: Array[Array[Int]],
					 i: Int,
					 j: Int,
					 vis: Array[Array[Boolean]]
					 ): Boolean = {

		(i >= 0) &&
		(i < isConnected.length) &&
		(j >= 0) &&
		(j <= isConnected.length) &&
		(isConnected(i)(j) == 1) &&
		(!vis(i)(j))
	}


	def BFS(isConnected: Array[Array[Int]], vis: Array[Array[Boolean]], si: Int, sj: Int): Array[Array[Boolean]] = {
		val ROW: Array[Int] =
			Array( -1, -1, -1, 0, 0, 1, 1, 1 )

		val LINE: Array[Int] =
			Array( -1, 0, 1, -1, 1, -1, 0, 1 )

		val q: Queue[(Int, Int)] = Queue()
		q.enqueue((si, sj))

		var newVis: Array[Array[Boolean]] = vis
		newVis(si)(sj) = true

		while (!q.isEmpty) {
			val EXTRACTED: (Int, Int) = q.dequeue()
			val i: Int = EXTRACTED._1
			val j: Int = EXTRACTED._2

			for (k <- Range.inclusive(0, 7)) {
				if (shouldInclude(isConnected, i + ROW(k), j + LINE(k), newVis)) {
					newVis(i + ROW(k))(j + LINE(k)) = true
					q.enqueue((i + ROW(k), j + LINE(k)))
				}
			}
		}

		newVis
	}


	def findCircleNum(isConnected: Array[Array[Int]]): Int = {
		val n: Int = isConnected.length

		var vis: Array[Array[Boolean]] =
			Array.fill(n) { Array.fill(n) { false } }

		var nrProv: Int = 0

		for (i <- Range.inclusive(0, n - 1)) {
			for (j <- Range.inclusive(0, n - 1)) {
				if (isConnected(i)(j) == 1 && !vis(i)(j)) {
					// BFS
					vis = BFS(isConnected, vis, i, j)
					nrProv += 1
				}
			}
		}

		nrProv
	}
}