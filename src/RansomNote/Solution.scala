package RansomNote

import scala.annotation.tailrec
import scala.collection.immutable.HashMap


// https://leetcode.com/problems/ransom-note/
object Solution {
	def canConstruct(ransomNote: String, magazine: String): Boolean = {
		@tailrec
		def getOccMap(s: String, occMap: HashMap[Char, Int] = HashMap()): HashMap[Char, Int] = {
			if (s.isEmpty) occMap
			else {
				val PREV_OCC: Int =
					occMap.getOrElse(s.head, 0)

				getOccMap(s.tail, occMap + (s.head -> (PREV_OCC + 1)))
			}
		}


		val RANSOM_OCC_MAP: HashMap[Char, Int] =
			getOccMap(ransomNote)

		val MAGAZINE_OCC_MAP: HashMap[Char, Int] =
			getOccMap(magazine)

		RANSOM_OCC_MAP.foreach(
			pr => {
				val LETTER: Char = pr._1
				val OCC: Int = pr._2

				MAGAZINE_OCC_MAP.get(LETTER) match {
					case Some(occ) => if (occ < OCC) return false
					case None => return false
				}
			}
		)

		true
	}
}
