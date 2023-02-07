package SumOfUnique

import scala.collection.immutable.HashMap


// https://leetcode.com/problems/sum-of-unique-elements/
object Solution {
	def sumOfUnique(nums: Array[Int], occMap: HashMap[Int, Int] = HashMap()): Int = {
		def getSum: Int = occMap.filter(pr => pr._2 == 1).keys.sum

		if (nums.isEmpty) getSum
		else {
			occMap.get(nums.head) match {
				case Some(occ) => sumOfUnique(nums.tail, occMap.updated(nums.head, occ + 1))
				case None => sumOfUnique(nums.tail, occMap + (nums.head -> 1))
			}
		}
	}
}
