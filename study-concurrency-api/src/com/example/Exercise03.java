package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Exercise03 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		var task = new CallableTask();
		var future = new FutureTask<>(task);
		var thread = new Thread(future, "thread-42");
		thread.start();
		System.out.println(future.get());
	}

}

class CallableTask implements Callable<Integer> {

	@Override
	public Integer call() {
		System.out.println("[%s] is running the task...".formatted(Thread.currentThread().getName()));
		return 42;
	}


}