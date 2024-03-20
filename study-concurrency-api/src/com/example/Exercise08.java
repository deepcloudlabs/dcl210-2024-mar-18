package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise08 {

	public static void main(String[] args) {
		ExecutorService executorService =  Executors.newScheduledThreadPool(20);
		executorService.submit(() -> {
			System.out.println("Hello Mars!");
		});
		executorService.submit(() -> {
			System.out.println("Hello Moon!");
		});
		executorService.shutdown();
	}

}
