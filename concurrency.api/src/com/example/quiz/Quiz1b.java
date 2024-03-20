package com.example.quiz;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Quiz1b {
	private static CyclicBarrier barrier = new CyclicBarrier(6);

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(()->{
			System.err.println("Thread-1 is waiting for Thread-10!");
			System.err.println("Thread-1 is waiting for Thread-11!");
			try {
				barrier.await();
				System.err.println("Thread-1 is just started!");
			} catch (InterruptedException | BrokenBarrierException e) {}
		});
		Thread t2 = new Thread(()->{
			System.err.println("Thread-2 is waiting for Thread-10!");
			System.err.println("Thread-2 is waiting for Thread-11!");			try {
				barrier.await();
				System.err.println("Thread-2 is just started!");
			} catch (InterruptedException | BrokenBarrierException e) {}
		});
		Thread t3 = new Thread(()->{
			System.err.println("Thread-3 is waiting for Thread-10!");
			System.err.println("Thread-3 is waiting for Thread-11!");			try {
				barrier.await();
				System.err.println("Thread-3 is just started!");
			} catch (InterruptedException | BrokenBarrierException e) {}
		});
		Thread t4 = new Thread(()->{
			System.err.println("Thread-4 is waiting for Thread-10!");
			System.err.println("Thread-4 is waiting for Thread-11!");			
			try {
				barrier.await();
				System.err.println("Thread-4 is just started!");
			} catch (InterruptedException | BrokenBarrierException e) {}
		});
		Thread t10 = new Thread(()->{
			System.err.println("Thread-10 is just started!");
			try {
				TimeUnit.SECONDS.sleep(10);
				System.err.println("Thread-10 is now ready!");
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {}
		});
		Thread t11 = new Thread(()->{
			System.err.println("Thread-11 is just started!");
			try {
				TimeUnit.SECONDS.sleep(5);
				System.err.println("Thread-11 is now ready!");
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {}
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t10.start();
		t11.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t10.join();
		t11.join();
	}

}
