package IncrFreqSort

import scala.annotation.tailrec
import scala.collection.immutable.HashMap


// https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
object Solution {
	def frequencySort(nums: Array[Int]): Array[Int] = {
		@tailrec
		def freqMap(nums: Array[Int] = nums, accFreq: HashMap[Int, Int] = HashMap()): HashMap[Int, Int] = {
			if (nums.isEmpty) accFreq
			else {
				val NEXT_FREQ: Int =
					accFreq
					.getOrElse(nums.head, 0) + 1

				freqMap(
					nums.tail,
					accFreq + (nums.head -> NEXT_FREQ)
				)
			}
		}


		freqMap()
		.toArray
		.sortBy(_._1)
		.reverse
		.sortBy(_._2)
		.flatMap(pr => List.fill(pr._2)(pr._1))
	}
}
