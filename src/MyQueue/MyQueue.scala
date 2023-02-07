package MyQueue

import scala.collection.mutable.Stack

// https://leetcode.com/problems/implement-queue-using-stacks/
class MyQueue() {
	private val internalS1: Stack[Int] = Stack()
	private val internalS2: Stack[Int] = Stack()

	def push(x: Int) {
		internalS1.push(x)
	}

	def pop(): Int = {
		if (internalS2.isEmpty) {
			while (internalS1.nonEmpty) {
				internalS2.push(internalS1.pop())
			}
		}

		internalS2.pop()
	}

	def peek(): Int = {
		if (internalS2.isEmpty) {
			while (internalS1.nonEmpty) {
				internalS2.push(internalS1.pop())
			}
		}

		internalS2.top
	}

	def empty(): Boolean = {
		internalS1.isEmpty && internalS2.isEmpty
	}

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */