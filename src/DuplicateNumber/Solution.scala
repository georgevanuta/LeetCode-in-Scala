package DuplicateNumber

// https://leetcode.com/problems/find-the-duplicate-number/
object Solution {
	def findDuplicate(nums: Array[Int]): Int = {
		nums.foldRight(Map(): Map[Int, Boolean])((curr: Int, acc: Map[Int, Boolean]) =>
			acc.get(curr) match {
				case Some(isTwice) => acc.updated(curr, true)
				case None => acc + (curr -> false)
			}).filter(x => x._2)
		.toArray
		.head
		._1
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		println(Solution.findDuplicate(Array(1, 3, 4, 2, 2)))
	}
}