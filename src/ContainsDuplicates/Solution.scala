package ContainsDuplicates

import scala.collection.immutable.HashMap


// https://leetcode.com/problems/contains-duplicate/description/
object Solution {
	def containsDuplicate(nums: Array[Int]): Boolean = {
		nums
		.foldRight(HashMap[Int, Boolean]())(
			(curr, acc) => {
				acc.get(curr) match {
					case Some(occ) => return true
					case None => acc + (curr -> false)
				}
			}
		)

		false
	}
}