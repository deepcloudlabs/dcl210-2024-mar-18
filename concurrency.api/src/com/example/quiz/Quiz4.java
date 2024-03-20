package com.example.quiz;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Quiz4 {

	public static void main(String[] args) throws InterruptedException {
		final var futureTask = new FutureTask<>(new Task());
		Thread producer = new Thread(futureTask);
		Thread consumer = new Thread(()->{
			try {
				System.err.println("Consumer is waiting for the result from the producer...");
				var result = futureTask.get();
				System.err.println("Consumer has the result: %s...".formatted(result));
			} catch (InterruptedException | ExecutionException e) {
			}
		});
		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
	}

}

class Task implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.err.println("Producer is working hard...");
		try{TimeUnit.SECONDS.sleep(10);}catch(Exception e) {}
		System.err.println("Producer is returning the result...");
		return 42;
	}
	
}

