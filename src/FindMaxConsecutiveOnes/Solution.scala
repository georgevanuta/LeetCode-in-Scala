package FindMaxConsecutiveOnes


// https://leetcode.com/problems/max-consecutive-ones/description/
object Solution {
	def findMaxConsecutiveOnes(nums: Array[Int], max: Int = 0, currSeq: Int = 0): Int = {
		if (nums.isEmpty) Math.max(max, currSeq)
		else if (nums.head == 0)  findMaxConsecutiveOnes(nums.tail, Math.max(max, currSeq), 0)
		else findMaxConsecutiveOnes(nums.tail, max, currSeq + 1)
	}
}