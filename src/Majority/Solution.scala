package Majority

import scala.collection.immutable.HashMap

// https://leetcode.com/problems/majority-element-ii/
object Solution {
	def majorityElement(nums: Array[Int]): List[Int] = {

		def getOccs(n: Array[Int], occs: HashMap[Int, Int] = HashMap()): HashMap[Int, Int] = {
			if (n.isEmpty) occs
			else {
				occs.get(n.head) match {
					case Some(key) => getOccs(n.tail, occs.updated(n.head, key + 1))
					case None => getOccs(n.tail, occs + (n.head -> 1))
				}
			}
		}

		val minSize: Int = nums.size / 3
		val occs: HashMap[Int, Int] = getOccs(nums)

		occs.filter((p) => p._2 > minSize).map(_._1).toList
	}
}