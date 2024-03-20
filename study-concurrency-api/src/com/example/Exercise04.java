package com.example;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Exercise04 {

	public static void main(String[] args) {
		var task = new RunnableCounterTask();
		var threads = IntStream.range(0, 10)
		         .mapToObj(i -> new Thread(task))
		         .toList();
		threads.forEach(Thread::start);
		threads.forEach(Exercise04::join);
		System.out.println("counter: %d".formatted(task.getCounter()));
	}

	public static void join(Thread thread) {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class RunnableCounterTask implements Runnable {
	private int counter = 0; // Heap
	@Override
	public void run() {
		System.out.println("[%s] is running the task...".formatted(Thread.currentThread().getName()));
		for (var i = 0; i < 10_000; ++i)
			synchronized (this) {
				counter++; // race -> critical section				
			}
	}

	public synchronized int getCounter() {
		return counter;
	}

}