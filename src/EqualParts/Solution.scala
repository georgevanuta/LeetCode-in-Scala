package EqualParts

import scala.annotation.tailrec
import scala.collection.immutable.HashMap


// https://leetcode.com/problems/divide-array-into-equal-pairs/description/
object Solution {
	def divideArray(nums: Array[Int]): Boolean = {
		@tailrec
		def occMap(nums: Array[Int], accMap: HashMap[Int, Int] = HashMap()): HashMap[Int, Int] = {
			if (nums.isEmpty) accMap
			else occMap(nums, accMap + (nums.head -> (accMap.getOrElse(nums.head, 0) + 1)))
		}

		occMap(nums)
		.forall(_._2 % 2 == 0)
	}
}
