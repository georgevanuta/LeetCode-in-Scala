package IsAnagram

import scala.collection.immutable.HashMap


// https://leetcode.com/problems/valid-anagram/
object Solution {
	private type AnagramMap = HashMap[Char, Int]

	def isAnagram(s: String, t: String): Boolean = {
		def constructAnagramMap(s: String, accMap: AnagramMap = HashMap()): AnagramMap = {
			if (s.isEmpty) accMap
			else {
				accMap
				.get(s.head) match {
					case Some(count) =>
						constructAnagramMap(
							s.tail,
							accMap + (s.head -> (count + 1))
						)
					case None =>
						constructAnagramMap(
							s.tail,
							accMap + (s.head -> 1)
						)
				}
			}
		}

		val S_MAP: AnagramMap = constructAnagramMap(s)
		val T_MAP: AnagramMap = constructAnagramMap(t)

		S_MAP == T_MAP
	}
}
