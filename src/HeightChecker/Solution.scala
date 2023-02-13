package HeightChecker

import scala.annotation.tailrec
import scala.collection.immutable.HashMap


// https://leetcode.com/problems/height-checker/
object Solution {
	def heightChecker(heights: Array[Int]): Int = {
		def getExpected(heights: Array[Int]): Array[Int] = {
			@tailrec
			def getHeightMap(heights: Array[Int], heightMap: HashMap[Int, Int] = HashMap()): HashMap[Int, Int] = {
				if (heights.isEmpty) heightMap
				else {
					val CURR_OCC = heightMap.getOrElse(heights.head, 0)
					getHeightMap(heights.tail, heightMap + (heights.head -> (CURR_OCC + 1)))
				}
			}

			@tailrec
			def dupElement(el: Int, times: Int, accDup: List[Int] = List()): List[Int] = {
				if (times == 0) accDup
				else dupElement(el, times - 1, el :: accDup)
			}

			getHeightMap(heights)
			.toArray
			.sortBy(_._1)
			.flatMap(pr => dupElement(pr._1, pr._2))
		}

		getExpected(heights)
		.zip(heights)
		.count(pr => pr._1 != pr._2)
	}
}
