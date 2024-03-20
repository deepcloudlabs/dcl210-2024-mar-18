package com.example;

import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

public class Exercise4 {
	public static void main(String[] args) {
		System.out.println("Application is just started!");
		var cpus = Runtime.getRuntime().availableProcessors();
		var latch = new CountDownLatch(cpus*cpus);
		var threads =
		Stream.generate(() -> new Thread(new LoadTestTask(latch)))
		      .limit(cpus*cpus)
		      .toList();
		threads.forEach(Thread::start);
		threads.forEach( thread -> {
			try { thread.join(); } catch (InterruptedException e) {}
		});
		System.out.println("Application is done!");
	}
}

@SuppressWarnings("unused")
class LoadTestTask implements Runnable {

	private final CountDownLatch countDownLatch;
	
	public LoadTestTask(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		try {
			System.out.println("%s is just started".formatted(threadName));
//			countDownLatch.countDown();
//			countDownLatch.await();
			System.out.println("Running the load test...%s".formatted(threadName));
		} catch (Exception e) {
			System.err.println("Error in thread (%s): %s".formatted(threadName,e.getMessage()));
		}
	}
	
}

//Application is just started!
//Thread-0 is just started
//Thread-3 is just started
//Thread-4 is just started
//Thread-7 is just started
//Thread-1 is just started
//Thread-5 is just started
//Thread-2 is just started
//Thread-6 is just started
//Running the load test...Thread-6
//Running the load test...Thread-0
//Running the load test...Thread-3
//Running the load test...Thread-4
//Running the load test...Thread-7
//Running the load test...Thread-1
//Running the load test...Thread-5
//Running the load test...Thread-2
//Application is done!
