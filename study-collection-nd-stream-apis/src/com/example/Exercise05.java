package com.example;

import java.util.ArrayList;

public class Exercise05 {

	public static void main(String[] args) {
		var numbers = new ArrayList<>(5_000_000);
		var start = System.currentTimeMillis();
		for (var i=0;i<5_000_000;++i)
			numbers.add(42);
		var stop = System.currentTimeMillis();
		System.out.println("Duration: %d ms.".formatted((stop-start)));
	}

}
