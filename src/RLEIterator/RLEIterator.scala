package RLEIterator


// https://leetcode.com/problems/rle-iterator/description/
class RLEIterator(_encoding: Array[Int]) {
	private var encoding: Array[Int] =
		_encoding
		.zipWithIndex
		.filter(
			_._2 % 2 == 0
		)
		.map(_._1)
		.zip(
			_encoding
			.zipWithIndex
			.filterNot(
				_._2 % 2 == 0
			)
			.map(_._1)
		)
		.filterNot(
			_._1 == 0
		)
		.flatMap(
			pr => List(pr._1, pr._2)
		)


	def next(n: Int): Int = {
		if (encoding.isEmpty) -1
		else if (encoding.head - n == 0) {
			val POPPED_VAL: Int =
				encoding
				.tail
				.head

			encoding =
				encoding
				.tail
				.tail

			POPPED_VAL
		}
		else if (encoding.head - n > 0) {
			encoding(0) = encoding.head - n

			encoding
			.tail
			.head
		}
		else {
			val DIFF: Int = n - encoding.head

			encoding =
				encoding
				.tail
				.tail

			next(
				DIFF
			)
		}

	}
}


