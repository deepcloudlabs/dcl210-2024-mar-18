package com.example.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Quiz2 {
	private final static MyConnectionPool CONNECTION_POOL = new MyConnectionPool(10);
	
	public static void main(String[] args) throws InterruptedException {
		var threads = new ArrayList<Thread>();
		for (var i=0;i<100;++i) {
			var thread = new Thread(()->{
				var connection = CONNECTION_POOL.getConnection();
				System.err.println("Using %s".formatted(connection.toString()));
				try {
					TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextLong(2, 6));
				} catch (InterruptedException e) {}
				System.err.println("Releasing %s".formatted(connection.toString()));
				CONNECTION_POOL.releaseConnection(connection);
			}); 
			thread.start();
			threads.add(thread);
		}
		for (var thread : threads)
			thread.join();
	}

}

class MyConnectionPool {
	private Semaphore semaphore;
	private List<Connection> availableConnections;
	private List<Connection> usedConnections;

	public MyConnectionPool(int poolSize) {
		semaphore = new Semaphore(poolSize);
		availableConnections = Collections.synchronizedList(new ArrayList<>());
		for (var i=1;i<=poolSize;++i)
			availableConnections.add(new Connection(i));
		usedConnections = Collections.synchronizedList(new ArrayList<>());
	}

	public Connection getConnection() {
		try {
			semaphore.acquire(1);
			var connection = availableConnections.remove(0);
			usedConnections.add(connection);
			return connection;
		} catch (InterruptedException e) {
		}
		return null;
	}

	public void releaseConnection(Connection connection) {
		usedConnections.remove(connection);
		availableConnections.add(connection);
		semaphore.release(1);
	}
}

class Connection {
	private final int id;

	public Connection(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Connection [id=" + id + "]";
	}

}