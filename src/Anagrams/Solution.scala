package Anagrams

// https://leetcode.com/problems/group-anagrams/
object Solution {
	def groupAnagrams(strs: Array[String]): List[List[String]] = {
		def isAnagram(str: String, str1: String): Boolean = {
			def charOcc(str: String): Map[String, Int] = {
				str.split("")
					.foldRight(Map(): Map[String, Int])((curr: String, acc: Map[String, Int]) =>
						acc.get(curr) match {
							case Some(occ) => acc.updated(curr, occ + 1)
							case None => acc + (curr -> 1)
						})
			}
			charOcc(str) == charOcc(str1)
		}

		if (strs.isEmpty) return List()

		val toFind: String = strs.head
		var otherStrs: List[String] = List()
		var foundStrs: List[String] = List(toFind)

		for (str <- strs.tail) {
			if (isAnagram(toFind, str)) foundStrs = str :: foundStrs
			else otherStrs = str :: otherStrs
		}

		foundStrs :: groupAnagrams(otherStrs.toArray)
	}
}

object Main {
	def main(args: Array[String]) = {
		println(Solution.groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat", "dff", "fdd")))
	}
}