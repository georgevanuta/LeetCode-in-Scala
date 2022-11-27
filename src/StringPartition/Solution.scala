package StringPartition

// https://leetcode.com/problems/partition-labels/
object Solution {
	def partitionLabels(s: String): List[Int] = {
		for (i <- 1 to s.size - 1) {
			val firstHalf: String =
				s.slice(0, i)

			val secondHalf: String =
				s.slice(i, s.size)

			if ((firstHalf.toSet intersect secondHalf.toSet).size == 0) {
				return partitionLabels(firstHalf) ++ partitionLabels(secondHalf)
			}
		}

		List(s.size)
	}
}
