package SingleNumberI

import scala.collection.immutable.HashMap


// https://leetcode.com/problems/single-number/
object Solution {
	def singleNumber(nums: Array[Int], countMap: HashMap[Int, Boolean]): Int = {
		if (nums.isEmpty)
			countMap.find(pr => pr._2) match {
				case Some(value) => value._1
				case None => throw new IllegalArgumentException("[ERROR]: No single element")
			}
		else
			countMap.get(nums.head) match {
				case Some(value) => singleNumber(nums.tail, countMap.updated(nums.head, false))
				case None => singleNumber(nums.tail, countMap + (nums.head -> true))
			}
	}
}