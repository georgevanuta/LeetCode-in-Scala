package HammingBinaryDistance

// https://leetcode.com/problems/hamming-distance/
object Solution {
	def pad(s: String, pattern: String, n: Int): String = {
		(pattern * n) ++ s
	}

	def hammingDistance(x: Int, y: Int): Int = {
		var xBinary: String = x.toBinaryString
		var yBinary: String = y.toBinaryString

		var maxSize: Int = Math.max(xBinary.size, yBinary.size)
		xBinary = pad(xBinary, "0", maxSize - xBinary.size)
		yBinary = pad(yBinary, "0", maxSize - yBinary.size)

		var hammingDistance: Int = 0

		Range.inclusive(0, maxSize - 1).foldRight(hammingDistance)(
			(curr, acc) => {
				if (xBinary(curr) != yBinary(curr)) acc + 1
				else acc
			}
		)
	}
}