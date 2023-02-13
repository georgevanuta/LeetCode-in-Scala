package MergeKLists


class ListNode(_x: Int = 0, _next: ListNode = null) {
	var next: ListNode = _next
	var x: Int = _x
}


// https://leetcode.com/problems/merge-k-sorted-lists/description/
object Solution {
	def mergeKLists(lists: Array[ListNode]): ListNode = {
		if (lists.forall(_ == null)) null
		else {
			val LISTS_TO_SEARCH: Array[ListNode] =
				lists
				.filterNot(_ == null)

			val MIN: ListNode = LISTS_TO_SEARCH.minBy(_.x)
			val INDEX: Int = LISTS_TO_SEARCH.indexWhere(_ == MIN)

			val NEW_LISTS: Array[ListNode] =
				LISTS_TO_SEARCH
				.slice(0, INDEX) ++
				Array(LISTS_TO_SEARCH(INDEX).next) ++
				LISTS_TO_SEARCH.slice(INDEX + 1, LISTS_TO_SEARCH.length)

			new ListNode(
				MIN.x,
				mergeKLists(NEW_LISTS)
			)
		}
	}
}
