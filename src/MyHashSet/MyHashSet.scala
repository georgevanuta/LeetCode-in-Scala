package MyHashSet


// https://leetcode.com/problems/design-hashset/description/
class MyHashSet() {
	private var internalSet: Set[Int] = Set()

	def add(key: Int): Unit = {
		internalSet += key
	}

	def remove(key: Int) {
		internalSet = internalSet.diff(Set(key))
	}

	def contains(key: Int): Boolean = {
		internalSet.contains(key)
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */