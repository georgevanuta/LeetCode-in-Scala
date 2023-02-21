package GoodSubstrings

import scala.annotation.tailrec
import scala.collection.immutable.HashMap


// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/
object Solution {
	@tailrec
	def countGoodSubstrings(s: String, accCount: Int = 0): Int = {
		@tailrec
		def isGoodString(s: String, occMap: HashMap[Char, Boolean] = HashMap()): Boolean = {
			if (s.isEmpty) true
			else {
				val IS_UNIQUE: Boolean =
					occMap
					.getOrElse(s.head, true)

				if (!IS_UNIQUE) false
				else
					isGoodString(
						s.tail,
						occMap + (s.head -> false)
					)
			}
		}

		if (s.length < 3) accCount
		else {
			val SUB_STRING: String = s.slice(0, 3)

			if (isGoodString(SUB_STRING))
				countGoodSubstrings(
					s.tail,
					accCount + 1
				)
			else
				countGoodSubstrings(
					s.tail,
					accCount
				)
		}
	}
}
