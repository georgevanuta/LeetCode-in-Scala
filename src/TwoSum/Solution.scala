package TwoSum

import scala.collection.mutable.HashMap

// https://leetcode.com/problems/two-sum/
object Solution {
	def twoSum(nums: Array[Int], target: Int): Array[Int] = {
		val complementMap: HashMap[Int, Int] = HashMap()

		for (i <- 0 to nums.size - 1) {
			if (complementMap.contains(nums(i))) {
				return Array(i, complementMap.getOrElse(nums(i), -1))
			}
			else {
				complementMap.put(target - nums(i), i)
			}
		}

		Array(-1, -1)
	}
}