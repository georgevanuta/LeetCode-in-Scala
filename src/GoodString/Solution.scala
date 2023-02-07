package GoodString

import scala.collection.mutable.HashMap
import scala.util.control.Breaks.{break, breakable}

// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
object Solution {
	def initCharsMap(chars: String): HashMap[Char, Int] = {
		val charsMap: HashMap[Char, Int] = HashMap[Char, Int]()

		for (ch <- chars.toList) {
			charsMap.get(ch) match {
				case Some(occ) => charsMap.update(ch, occ + 1)
				case None => charsMap.put(ch, 1)
			}
		}

		charsMap
	}

	def countCharacters(words: Array[String], chars: String): Int = {
		var length: Int = 0

		for (word <- words) {
			val copyCharsMap: HashMap[Char, Int] = initCharsMap(chars)
			var canBeFormed: Boolean = true

			for (ch <- word) {
				breakable {
					if (copyCharsMap.getOrElse(ch, 0) >= 1) {
						copyCharsMap.update(ch, copyCharsMap.getOrElse(ch, 0) - 1)
					} else {
						canBeFormed = false
						break()
					}
 				}
			}

			if (canBeFormed) {
				length += word.length
			}
		}

		length
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		val words = Array("cat","bt","hat","tree")
		val chars = "atach"

		println(Solution.countCharacters(words, chars))
	}
}