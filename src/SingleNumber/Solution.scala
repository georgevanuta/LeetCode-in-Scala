package SingleNumber

// https://leetcode.com/problems/single-number-iii/
object Solution {
	def singleNumber(nums: Array[Int]): Array[Int] = {
		nums.foldRight(Map(): Map[Int, Boolean])((curr: Int, acc: Map[Int, Boolean]) =>
			acc.get(curr) match {
				case Some(_) => acc.updated(curr, false)
				case None => acc + (curr -> true)
			}).filter(x => x._2).map(_._1).toArray
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		println(Solution.singleNumber(Array(1, 2, 1, 3, 2, 5)).toList)
	}
}