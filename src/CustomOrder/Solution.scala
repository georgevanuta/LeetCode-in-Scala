package CustomOrder

// https://leetcode.com/problems/custom-sort-string/
object Solution {
	def customSortString(order: String, s: String): String = {
		var sToWorkOn: String = s
		var orderList: List[Char] = order.toList
		var sSorted: String = ""

		while (orderList.nonEmpty) {
			for (ch <- sToWorkOn) {
				if (ch == orderList.head) {
					sSorted :+= ch
				}
			}
			sToWorkOn = sToWorkOn.filter(c => c != orderList.head)
			orderList = orderList.tail
		}

		sSorted ++ sToWorkOn
	}
}