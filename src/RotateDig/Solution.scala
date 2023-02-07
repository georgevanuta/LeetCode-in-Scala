package RotateDig

// https://leetcode.com/problems/rotated-digits/
object Solution {
	def rotatedDigits(n: Int): Int = {
		def rotateDig(d: Int): Int = {
			d match {
				case 0 => 0
				case 1 => 1
				case 8 => 8
				case 2 => 5
				case 5 => 2
				case 6 => 9
				case 9 => 6
				// the next digits don't rotate
				case 7 => -1
				case 3 => -1
				case 4 => -1
			}
		}

		def isValid(number: Int): Boolean = {
			val digs: List[Int] =
				number.toString.map(_.asDigit).toList

			var rotatedNumber: String = ""

			for (dig <- digs) {
				if (rotateDig(dig) == -1) return false

				rotatedNumber ++= rotateDig(dig).toString
			}

			rotatedNumber.toInt != number
		}

		(1 to n).filter(isValid(_)).size
	}
}

object Main extends App {
	println(Solution.rotatedDigits(10))
}