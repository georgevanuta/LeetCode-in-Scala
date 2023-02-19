package FooBar;

import java.util.concurrent.Semaphore;


// https://leetcode.com/problems/print-foobar-alternately/
class FooBar {
	private int n;
	private Semaphore fooSemaphore;
	private Semaphore barSemaphore;

	public FooBar(int n) {
		this.n = n;
		this.fooSemaphore = new Semaphore(1);
		this.barSemaphore = new Semaphore(0);
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			this.fooSemaphore.acquire();

			// printFoo.run() outputs "foo". Do not change or remove this line.
			printFoo.run();

			this.barSemaphore.release();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			this.barSemaphore.acquire();

			// printBar.run() outputs "bar". Do not change or remove this line.
			printBar.run();

			this.fooSemaphore.release();
		}
	}
}
