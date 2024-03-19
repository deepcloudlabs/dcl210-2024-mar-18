package com.example;

import java.util.Set;

public class Exercise01 {

	public static void main(String[] args) {
		// Legacy API: Since Java 1
		// Vector -> ArrayList/LinkedList, Stack->Deque
		// Thread Safe

		// Collection API: Java 1.2
		// List : Linear, Ordered, Allows duplicates
		// Set : Linear, Un-ordered, Unique
		// Map : Associative: Key -> Value
		// Deque: ~List, Queue (FIFO), Stack(LIFO)

		// Thread-Unsafe Collections: Most of them fall in this group
		// Thread-Safe Collections: ConcurrentHashMap,
		// BlockingQueue,CopyOnWriteArrayList
		// Thread-Unsafe Collections --
		// Collections.synchronizedCollection/synchronizedList/synchronizedSet/synchronizedMap
		// --> Thread-Safe Collections

		// Memory Consumption -> Space Complexity: Dynamic/Elastic
		// Big-O Complexity -> Time Complexity

		Set<Integer> numbers = Set.of(4, 8, 15, 16, 23, 42);
		// Iterator Pattern
		var iter = numbers.iterator();
		while (iter.hasNext()) {
			var number = iter.next();
			System.out.println(number);
		}
		for (var number: numbers) { // since java se 5 
			System.out.println(number);			
		}
		// imperative solutions
		// Stream API -> spliterator -> ForkJoin Framework
	}

}
