package FindAnagrams

import scala.collection.mutable.HashMap


// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
object Solution {
	def findAnagrams(s: String,
					 p: String): List[Int] = {

		def occMap(str: String, occs: HashMap[Char, Int] = HashMap()): HashMap[Char, Int] = {
			if (str.isEmpty) occs
			else {
				occs.get(str.head) match {
					case Some(nr) => occMap(str.tail, occs + (str.head -> (nr + 1)))
					case None => occMap(str.tail, occs + (str.head -> 1))
				}
			}
		}


		def areOccsEqual(occ1: HashMap[Char, Int], occ2: HashMap[Char, Int]): Boolean = {
			occ1.filter(_._2 > 0) == occ2
		}



		val S_LENGTH: Int = s.length
		val P_LENGTH: Int = p.length

		val FIRST_SLICE: String = s.slice(0, P_LENGTH)

		val sliceMap: HashMap[Char, Int] = occMap(FIRST_SLICE)
		val pMap: HashMap[Char, Int] = occMap(p)

		var res: List[Int] = List()

		if (sliceMap == pMap) res ::= 0

		for (i <- 1 to S_LENGTH - P_LENGTH) {

			sliceMap.update(s(i - 1), sliceMap.getOrElse(s(i - 1), 1) - 1)
			sliceMap.update(s(i + P_LENGTH - 1), sliceMap.getOrElse(s(i + P_LENGTH - 1), 0) + 1)

			if (areOccsEqual(sliceMap, pMap)) res ::= i
		}

		res
	}
}
