package CompareVersions


// https://leetcode.com/problems/compare-version-numbers/
object Solution {
	def compareVersion(version1: String, version2: String): Int = {
		def compareRevisionAsLists(version1: List[Int], version2: List[Int]): Int = {
			if (version1.isEmpty && version2.isEmpty) 0
			else if (version1.isEmpty && version2.forall(_ == 0)) 0
			else if (version2.isEmpty && version1.forall(_ == 0)) 0
			else if (version1.isEmpty) -1
			else if (version2.isEmpty) 1
			else if (version1.forall(_ == 0) && version2.forall(_ == 0)) 0
			else if (version1.head > version2.head) 1
			else if (version1.head < version2.head) -1
			else compareRevisionAsLists(version1.tail, version2.tail)
		}

		def splitVersion(version: String): List[Int] = {
			version
			.split('.')
			.map(_.toInt)
			.toList
		}

		val VERSION_LIST1: List[Int] = splitVersion(version1)
		val VERSION_LIST2: List[Int] = splitVersion(version2)

		compareRevisionAsLists(VERSION_LIST1, VERSION_LIST2)
	}
}

