package SquareOrder

// https://leetcode.com/problems/squares-of-a-sorted-array/
object Solution {
	def sortedSquares(nums: Array[Int]): Array[Int] = {

		def findPivot(): Int = {
			for (i <- 0 to (nums.size - 1)) {
				if (nums(i) >= 0) return i
			}

			nums.size - 1
		}

		val pivot: Int = findPivot()


		var posPart: Array[Int] = nums.slice(pivot, nums.size)
		var negPart: Array[Int] = nums.slice(0, pivot).reverse

		var res: Array[Int] = Array[Int]()


		while (posPart.nonEmpty && negPart.nonEmpty) {
			var sqr1: Int = posPart.head * posPart.head
			var sqr2: Int = negPart.head * negPart.head

			if (sqr1 < sqr2) {
				res :+= sqr1
				posPart = posPart.tail
			}
			else {
				res :+= sqr2
				negPart = negPart.tail
			}
		}

		while (posPart.nonEmpty) {
			res :+= posPart.head * posPart.head
			posPart = posPart.tail
		}

		while (negPart.nonEmpty) {
			res :+= negPart.head * negPart.head
			negPart = negPart.tail
		}

		res
	}
}
