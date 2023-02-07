package Hamming

// https://leetcode.com/problems/number-of-1-bits/
object Solution {
	// you need treat n as an unsigned value
	def hammingWeight(n: Int): Int = {
		"1".r.findAllIn(n.toBinaryString).size
	}
}
