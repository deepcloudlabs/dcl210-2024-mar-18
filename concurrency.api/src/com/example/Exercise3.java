package com.example;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Exercise3 {

	public static void main(String[] args) {
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("Application is running now...");
		final ScheduledThreadPoolExecutor scheduler = 
				(ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(processors);
		ScheduledFuture<?> myHandler = scheduler.scheduleAtFixedRate(new ScheduledTask(), 5, 3, TimeUnit.SECONDS);
		
		scheduler.schedule(() -> {
			myHandler.cancel(true);
			scheduler.shutdown();
			System.out.println("Application is done.");
		}, 20, TimeUnit.SECONDS);
	}

}

class ScheduledTask implements Runnable {

	@Override
	public void run() {
		System.out.println("ScheduledTask is running at %s".formatted(new Date()));
	}
	
}