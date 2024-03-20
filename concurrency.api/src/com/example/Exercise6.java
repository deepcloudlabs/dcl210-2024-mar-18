package com.example;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise6 {
	public static void main(String[] args) {
		var task = new Task();
		var threads = new ArrayList<Thread>();
		for (var i=0;i<8;++i) {
			threads.add(new Thread(task));
		}
		long start = System.currentTimeMillis();
		threads.forEach(Thread::start);
		threads.forEach( thread -> {
			try { thread.join(); } catch (InterruptedException e) {}
		});
		long stop = System.currentTimeMillis();
		System.out.println("counter: %d @ %d.".formatted(task.getCounter(),(stop-start)));
	}
}

class Task implements Runnable {
	private int counter; // instance variable -> Heap 

	public int getCounter() {
		return counter;
	}

	@Override
	public void run() {
		synchronized (this) {
		for (var i = 0; i < 2_000_000; ++i)
				counter++;				
			}
	}

}

// Lock-free Solution -> AtomicInteger
class AtomicTask implements Runnable {
	private AtomicInteger counter = new AtomicInteger(0); // instance variable -> Heap 
	
	public int getCounter() {
		return counter.get();
	}
	
	@Override
	public void run() {
		Thread.onSpinWait();
		for (var i = 0; i < 2_000_000; ++i)
			counter.incrementAndGet();				
	}
	
}
