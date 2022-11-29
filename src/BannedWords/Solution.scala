package BannedWords

import scala.collection.immutable.HashMap

// https://leetcode.com/problems/most-common-word/
object Solution {
	def mostCommonWord(paragraph: String, banned: Array[String]): String = {
		paragraph.toLowerCase
				 .replaceAll("[,|.|!|?|;|']", "")
				 .replaceAll("\\s+", " ")
				 .split(" ")
				 .foldRight(HashMap[String, Int]())(
					 (curr, acc) => {
						 if (banned.contains(curr)) {
							 acc
						 }
						 else {
							 acc.get(curr) match {
								 case Some(occs) => acc.updated(curr, occs + 1)
								 case None => acc.updated(curr, 1)
							 }
						 }
					 }
				 )
				 .maxBy(_._2)
				 ._1

	}
}

object Main extends App {
	val paragraph: String = "Bob hit a ball, the hit BALL flew far after it was hit."
	val banned: Array[String] = Array("hit")
	println(Solution.mostCommonWord(paragraph, banned))
}