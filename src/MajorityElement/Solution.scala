package MajorityElement

import scala.collection.immutable.HashMap

// https://leetcode.com/problems/majority-element/
object Solution {
	def majorityElement(nums: Array[Int]): Int = {
		def recurse(array: Array[Int], occMap: HashMap[Int, Int] = HashMap()): Int = {

			def getMajorityElement: Int = {
				occMap.find(pr => pr._2 > Math.floor(nums.length / 2 + 1)) match {
					case Some(value) => value._1
					case None => throw new IllegalArgumentException("[ERROR]: No majority element")
				}
			}

			if (array.isEmpty) getMajorityElement
			else {
				occMap.get(array.head) match {
					case Some(occ) => recurse(array.tail, occMap.updated(array.head, occ + 1))
					case None => recurse(array.tail, occMap + (array.head -> 1))
				}
			}
		}

		recurse(nums)
	}
}