package com.example;

import java.util.HashMap;

public class Exercise06 {

	public static void main(String[] args) {
		var numbers = new HashMap<Integer,Integer>(8_000_000);
		var start = System.currentTimeMillis();
		for (var i=0;i<6_000_000;++i)
			numbers.put(i,42);
		var stop = System.currentTimeMillis();
		System.out.println("Duration: %d ms.".formatted((stop-start)));
	}

}
