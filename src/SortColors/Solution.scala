package SortColors

import scala.collection.immutable.HashMap

// https://leetcode.com/problems/sort-colors/
object Solution {
	def sortColors(nums: Array[Int]): Unit = {
		val colorMap: HashMap[Int, Int] =
			nums.foldRight(HashMap[Int, Int]())(
				(curr, acc) => {
					acc.get(curr) match {
						case Some(occ) => acc.updated(curr, 1 + occ)
						case None => acc + (curr -> 1)
					}
				}
			)

		var i: Int = 0

		def addColor(color: Int): Unit = {
			for (j <- 0 until colorMap.getOrElse(color, 0)) {
				nums(i) = color
				i += 1
			}
		}

		addColor(0)
		addColor(1)
		addColor(2)
	}
}