package com.example;

import java.util.concurrent.Semaphore;

public class Exercise5 {

	public static void main(String[] args) {
		Semaphore mySemaphore = new Semaphore(10);
		new Thread(() -> {
			try {
				mySemaphore.acquire(3);
				// use the resource
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				mySemaphore.release(3);				
			}
		}).start();

	}

}
