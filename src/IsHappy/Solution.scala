package IsHappy

import scala.annotation.tailrec


// https://leetcode.com/problems/happy-number/description/
object Solution {
	@tailrec
	def isHappy(n: Int, vis: Set[Int] = Set()): Boolean = {
		def nextNum: Int = {
			n
			.toString
			.split("")
			.map(_.toInt)
			.map(x => x * x)
			.sum
		}


		if (n == 1) true
		else if (vis.contains(n)) false
		else isHappy(nextNum, vis + n)
	}
}
