package com.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class Exercise06 {

	public static void main(String[] args) {
		var task = new TaskB();
		var threads = IntStream.range(0, 10)
		         .mapToObj(i -> new Thread(task))
		         .toList();
		threads.forEach(Thread::start);
		threads.forEach(Exercise05::join);
		System.out.println("counter: %d".formatted(task.getSize()));
	}

}

class TaskB implements Runnable {
	private ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

	@Override
	public void run() {
		for (var i = 0; i < 10_000; ++i) {
			map.put(i, 42);
		}
	}

	public int getSize() {
		return map.size();
	}

}