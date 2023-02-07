package ShuffleString

// https://leetcode.com/problems/shuffle-string/
object Solution {
	def restoreString(s: String, indices: Array[Int]): String = {
		val sRestored: Array[Char] = Array.ofDim(s.length)
		s.zipWithIndex.foreach(c => sRestored(indices(c._2)) = c._1)
		sRestored.mkString("")
	}
}