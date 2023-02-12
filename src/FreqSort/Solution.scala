package FreqSort

import scala.annotation.tailrec
import scala.collection.immutable.HashMap


// 451. Sort Characters By Frequency
object Solution {
	def frequencySort(s: String): String = {

		@tailrec
		def getOccMap(s: String, occMap: HashMap[Char, Int] = HashMap()): HashMap[Char, Int] = {
			if (s.isEmpty) occMap
			else {
				val OCC: Int = occMap.getOrElse(s.head, 0)

				getOccMap(s.tail, occMap + (s.head -> (OCC + 1)))
			}
		}

		val OCC_MAP: HashMap[Char, Int] =
			getOccMap(s)


		OCC_MAP
		.toList
		.sortBy(_._2)(Ordering.Int.reverse)
		.map(pr => pr._1.toString * pr._2)
		.mkString
	}
}
