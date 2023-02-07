package FlipInvert

// https://leetcode.com/problems/flipping-an-image/
object Solution {
	def flipAndInvertImage(image: Array[Array[Int]]): Array[Array[Int]] = {
		image.map(_.reverse).map((bits) => bits.map((bit) => if (bit == 1) 0 else 1))
	}
}


object Main {
	def main(args: Array[String]): Unit = {
		val image: Array[Array[Integer]] =
			Array(
				Array(1, 1, 0),
				Array(0, 1, 0),
				Array(0, 0, 0)
			)
	}
}