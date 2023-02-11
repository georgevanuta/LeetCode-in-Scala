package FirstUniqueChar

import scala.collection.immutable.HashMap


// https://leetcode.com/problems/first-unique-character-in-a-string/description/
object Solution {
	def firstUniqChar(s: String): Int = {
		def createOccMap(
						s: String,
						accMap: HashMap[Char, Int] = HashMap(),
						currIndex: Int = 0): HashMap[Char, Int] = {

			if (s.isEmpty) accMap
			else {
				accMap.get(s.head) match {
					case Some(_) => {
						createOccMap(
							s.tail,
							accMap + (s.head -> -1),
							currIndex + 1
						)
					}
					case None => {
						createOccMap(
							s.tail,
							accMap + (s.head -> currIndex),
							currIndex + 1
						)
					}
				}
			}

		}


		val OCC_MAP: HashMap[Char, Int] = createOccMap(s)

		val DISTINCT_INDICIES: Iterable[Int] =
			OCC_MAP
			.values
			.filter(_ > -1)


		if (DISTINCT_INDICIES.isEmpty) -1
		else DISTINCT_INDICIES.min
	}
}