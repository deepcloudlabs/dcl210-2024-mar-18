package com.example;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Exercise05 {

	public static void main(String[] args) {
		var task = new CounterTask();
		var threads = IntStream.range(0, 10)
		         .mapToObj(i -> new Thread(task))
		         .toList();
		threads.forEach(Thread::start);
		threads.forEach(Exercise05::join);
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


class CounterTask implements Runnable {
	private int counter = 0; // Heap
	private ReentrantLock rel = new ReentrantLock();
	@Override
	public void run() {
		System.out.println("[%s] is running the task...".formatted(Thread.currentThread().getName()));
		for (var i = 0; i < 10_000; ++i)
			try{
				rel.lock();
				counter++; // race -> critical section				
			}finally {
				rel.unlock();
			}
	}

	public int getCounter() {
		try{
			rel.lock();
			return counter;
		}finally {
			rel.unlock();
		}
	}

}