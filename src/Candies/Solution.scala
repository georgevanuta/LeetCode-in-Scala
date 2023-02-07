package Candies

// https://leetcode.com/problems/distribute-candies/
object Solution {
	def distributeCandies(candyType: Array[Int]): Int = {
		val maxUniqueCandies: Int = candyType.toSet.size
		val maxCandies: Int = candyType.size / 2

		if (maxUniqueCandies >= maxCandies) maxCandies
		else maxUniqueCandies
	}
}