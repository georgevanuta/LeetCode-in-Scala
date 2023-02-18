package PrintOrder;

import java.util.concurrent.Semaphore;


// https://leetcode.com/problems/print-in-order/
class Foo {
	private Semaphore semaphoreFirst, semaphoreSecond;

	public Foo() {
		semaphoreFirst = new Semaphore(0);
		semaphoreSecond = new Semaphore(0);
	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		semaphoreFirst.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {

		// printSecond.run() outputs "second". Do not change or remove this line.
		semaphoreFirst.acquire();
		printSecond.run();
		semaphoreSecond.release();
	}

	public void third(Runnable printThird) throws InterruptedException {

		// printThird.run() outputs "third". Do not change or remove this line.
		semaphoreSecond.acquire();
		printThird.run();
	}
}