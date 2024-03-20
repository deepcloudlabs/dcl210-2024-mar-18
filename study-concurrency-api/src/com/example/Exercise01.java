package com.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise01 {
	public static final ExecutorService threadPool = Executors.newFixedThreadPool(20);

	public static void main(String[] args) {
		var service = new BusinessService();
		var result = service.fun();
		System.out.println("result is %d.".formatted(result));
		var future = service.gun();
		// observer
		future.thenAcceptAsync( response ->{
			System.out.println("response is %d.".formatted(response));
		});
		System.out.println("Application is done.");
		try {TimeUnit.SECONDS.sleep(15);} catch (InterruptedException e) {}
		threadPool.shutdown();
	}

}

class BusinessService {
	
	public int fun() { // synchronous
		return 42;
	}
	
	public CompletableFuture<Integer> gun() { // asynchronous
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("%s runs CompletableFuture.supplyAsync()".formatted(Thread.currentThread().getName()));
			try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {}
			return 42;
		},Exercise01.threadPool);
	}
}