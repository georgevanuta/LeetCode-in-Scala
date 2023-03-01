package DigitCount

import scala.annotation.tailrec
import scala.collection.immutable.HashMap


// https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
object Solution {
	def digitCount(num: String): Boolean = {
		@tailrec
		def occMap(nums: Array[Int], accOcc: HashMap[Int, Int] = HashMap()): HashMap[Int, Int] = {
			if (nums.isEmpty) accOcc
			else {
				val NEXT_OCC: Int =
					accOcc
					.getOrElse(nums.head, 0) + 1

				occMap(
					nums.tail,
					accOcc + (nums.head -> NEXT_OCC)
				)
			}
		}

		val NUM_SPLIT: Array[Int] =
			num
			.split("")
			.map(_.toInt)

		val OCC_MAP: HashMap[Int, Int] =
			occMap(NUM_SPLIT)

		num
		.indices
		.map(
			i => OCC_MAP.getOrElse(i, 0)
		)
		.zip(NUM_SPLIT)
		.forall(pr => pr._1 == pr._2)
	}
}
