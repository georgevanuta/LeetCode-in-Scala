package Fibo

// https://leetcode.com/problems/fibonacci-number/
object Solution {
	def fib(n: Int): Int = {
		if (n == 0) 0
		else if (n == 1) 1
		else fib(n - 1) + fib(n - 2)
	}
}