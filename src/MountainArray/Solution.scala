package MountainArray


// https://leetcode.com/problems/valid-mountain-array/
object Solution {
	def validMountainArray(arr: Array[Int]): Boolean = {
		def increasing(array: Array[Int], prev: Int, must: Boolean = false): Boolean = {
			if (array.isEmpty) false
			else if (array.head > prev) increasing(array.tail, array.head)
			else if (must) false
			else decreasing(array, prev, true)
		}

		def decreasing(array: Array[Int], prev: Int, must: Boolean = false): Boolean = {
			if (array.isEmpty && must) false
			else if (array.isEmpty) true
			else if (array.head < prev) decreasing(array.tail, array.head)
			else false
		}

		if (arr.length <= 2) false
		else increasing(arr, Integer.MIN_VALUE, true)
	}
}


