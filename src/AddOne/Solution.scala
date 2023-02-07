package AddOne

object Solution {
	def plusOne(digits: Array[Int]): Array[Int] = {
		def plusOneReverse(digs: Array[Int], carry: Int = 1): List[Int] = {
			if (digs.isEmpty && carry == 1) List(1)
			else if (digs.isEmpty) List()
			else List(((digs.head + carry) % 10)) ++ plusOneReverse(digs.tail, (digs.head + carry) / 10)
		}

		plusOneReverse(digits.reverse).toArray
	}
}
