package com.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Exercise07 {

	public static void main(String[] args) {
		var task = new TaskC();
		var threads = IntStream.range(0, 10).mapToObj(i -> new Thread(task)).toList();
		threads.forEach(Thread::start);
		threads.forEach(Exercise07::join);
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

class TaskC implements Runnable {
	private AtomicInteger counter = new AtomicInteger(0); // Heap

	@Override
	public void run() {
		System.out.println("[%s] is running the task...".formatted(Thread.currentThread().getName()));
		for (var i = 0; i < 10_000; ++i)
			counter.incrementAndGet(); // race -> critical section
	}

	public int getCounter() {
		return counter.get();
	}

}