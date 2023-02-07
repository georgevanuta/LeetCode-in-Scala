package MaxFruits

import scala.util.control.Breaks.{break, breakable}

object Solution {
	def totalFruit(fruits: Array[Int]): Int = {
		var max: Int = -1

		for (i <- 0 to fruits.size - 1) {
			val firstFruit: Int = fruits(i)
			var secondFruit: Int = fruits(i)

			var fruitsFound: Int = 1

			var continuedIndex: Int = i + 1

			for (j <- i + 1 to fruits.size - 1) {
				continuedIndex += 1

				if (fruits(j) != firstFruit) {
					breakable {
						fruitsFound += 1
						secondFruit = fruits(j)
						break
					}
				}
				else fruitsFound += 1
			}

			for (j <- continuedIndex to fruits.size - 1) {
				if (fruits(j) == firstFruit || fruits(j) == secondFruit) fruitsFound += 1
				else {
					breakable {
						break
					}
				}
			}


			max = Math.max(max, fruitsFound)
			println("-----------")
			println(firstFruit)
			println(secondFruit)
			println(max)
			println("-----------")		}

		max
	}
}


object Main {
	def main(args: Array[String]): Unit = {
		val frs: Array[Int] =
			Array(0, 1, 2, 2)

		println(Solution.totalFruit(frs))
	}
}