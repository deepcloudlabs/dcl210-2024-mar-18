package com.example;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Exercise02 {

	public static void main(String[] args) {
		// Thread Pool => ExecutorService
//		var threadPool = Executors.newFixedThreadPool(10 * Runtime.getRuntime().availableProcessors());
		var threadPool = Executors.newSingleThreadScheduledExecutor();
		IntStream.range(0, 10_000)
		         .forEach( i -> { 
		        	 try{TimeUnit.NANOSECONDS.sleep(1);}catch(Exception e) {} 
		        	 threadPool.submit(() -> System.out.println("[%s] Hello World [%d]!".formatted(Thread.currentThread().getName(),i)));
		         });
		threadPool.shutdown();
		/*
Hello World [7]!
Hello World [5]!
Hello World [1]!
Hello World [2]!
Hello World [4]!
Hello World [8]!
Hello World [10]!
		 */
	}

}
