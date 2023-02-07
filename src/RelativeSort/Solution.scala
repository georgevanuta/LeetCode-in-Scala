package RelativeSort

// https://leetcode.com/problems/relative-sort-array/
object Solution {
	def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
		arr1.filter(x => arr2.contains(x)).sortWith(
			(e1, e2) => {
				arr2.indexOf(e1) < arr2.indexOf(e2)
			}
		) ++
		arr1.filterNot(x => arr2.contains(x)).sorted
	}
}
