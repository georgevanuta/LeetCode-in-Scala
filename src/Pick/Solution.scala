package Pick

import scala.collection.mutable.HashMap
import scala.util.Random


// https://leetcode.com/problems/random-pick-index/
class Solution(_nums: Array[Int]) {
	var nums: Array[Int] = _nums
	var indexMap: HashMap[Int, Array[Int]] = HashMap()

	def pick(target: Int): Int = {
		indexMap.get(target) match {
			case Some(indexes) => Random.shuffle(indexes).head
			case None => {
				val indxs: Array[Int] = nums.zipWithIndex.filter(_._1 == target).map(_._2)
				indexMap.update(target, indxs)
				nums = nums.filterNot(_ == target)

				Random.shuffle(indxs).head
			}
		}
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.pick(target)
 */