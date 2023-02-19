package H2O;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


// https://leetcode.com/problems/building-h2o/
class H2O {
	private Semaphore hydrogenSemaphore;
	private Semaphore oxygenSemaphore;
	private CyclicBarrier waterBarrier;

	public H2O() {
		this.hydrogenSemaphore = new Semaphore(0);
		this.oxygenSemaphore = new Semaphore(1);
		this.waterBarrier = new CyclicBarrier(3);
	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		this.hydrogenSemaphore.acquire();
		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
		releaseHydrogen.run();
		try {
			this.waterBarrier.await();
		} catch (BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		this.oxygenSemaphore.acquire();
		this.hydrogenSemaphore.release(2);
		// releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		try {
			this.waterBarrier.await();
		} catch (BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
		this.oxygenSemaphore.release();
	}
}
