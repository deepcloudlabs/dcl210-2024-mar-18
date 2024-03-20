package com.example;

public class Exercise02 {

	public static void main(String[] args) throws InterruptedException {
		RunnableTask task = new RunnableTask();
		var thread = new Thread(task, "thread-42");
		thread.start();
		thread.join();
		System.out.println(task.getSolution());
	}

}

class RunnableTask implements Runnable {
	private int solution;

	@Override
	public void run() {
		System.out.println("[%s] is running the task...".formatted(Thread.currentThread().getName()));
		solution = 42;
	}

	public int getSolution() {
		return solution;
	}

}