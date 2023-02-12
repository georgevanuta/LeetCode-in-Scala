package FindTheDifference

import scala.annotation.tailrec
import scala.collection.immutable.HashMap


// https://leetcode.com/problems/find-the-difference/description/
object Solution {
	def findTheDifference(s: String, t: String): Char = {
		@tailrec
		def getOccMap(s: String, occMap: HashMap[Char, Int] = HashMap()): HashMap[Char, Int] = {
			if (s.isEmpty) occMap
			else {
				val PREV_OCC: Int =
					occMap.getOrElse(s.head, 0)

				getOccMap(s.tail, occMap + (s.head -> (PREV_OCC + 1)))
			}
		}


		val S_OCC_MAP: HashMap[Char, Int] =
			getOccMap(s)

		val T_OCC_MAP: HashMap[Char, Int] =
			getOccMap(t)

		T_OCC_MAP
		.toList
		.diff(S_OCC_MAP.toList)
		.head
		._1
	}
}
