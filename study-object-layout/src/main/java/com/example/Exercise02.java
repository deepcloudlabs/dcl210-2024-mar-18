package com.example;

import java.util.List;

public class Exercise02 {
	public static void main(String[] args) {
		// -Djava.lang.Integer.IntegerCache.high=2048
		// Object Pooling -> Immutable
		Integer x = Integer.valueOf(42); // [-128..127] 
		Integer y = 42;
		Integer u = 542;
		Integer v = 542;
		System.out.println("x==y? "+(x.equals(y))); // true
		System.out.println("u==v? "+(u.equals(v))); // false
		List<Integer> numbers = List.of(4,8,15,16,23,42);
		// 4B reference + 4 -> 12B + 4B = 16B = 20B
		// CPU Cache
	}
}
