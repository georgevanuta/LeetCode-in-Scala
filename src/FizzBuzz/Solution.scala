package FizzBuzz


// https://leetcode.com/problems/fizz-buzz/
object Solution {
	def fizzBuzz(n: Int): List[String] = {
		def fizzBuzzElement(i: Int): String = {
			var s: String = ""

			if (i % 3 == 0) s ++= "Fizz"
			if (i % 5 == 0) s ++= "Buzz"

			if (s.isEmpty) i.toString
			else s
		}

		(1 to n)
		.map(i => fizzBuzzElement(i))
		.toList
	}
}