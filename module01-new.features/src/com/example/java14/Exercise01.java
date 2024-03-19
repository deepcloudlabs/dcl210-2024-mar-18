package com.example.java14;

import java.util.List;

public class Exercise01 {

	public static void main(String[] args) {
		// value-typed
		int x = 42; // 4-Byte
		// reference
		Integer y = Integer.valueOf(42); // 4-byte + Heap(12B + 4B=16B) = 20B 
		List<Integer> numbers = List.of(4,8,15,16,23,42);

	}

}
