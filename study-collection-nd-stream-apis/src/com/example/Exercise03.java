package com.example;

import java.util.IdentityHashMap;
import java.util.Map;

public class Exercise03 {

	public static void main(String[] args) {
		Map<Integer, String> map = new IdentityHashMap<Integer, String>();
		map.put(Integer.valueOf(108), "108"); // 1 1 1
		System.out.println(map.size());
		map.put(108, "108"); // 1 1 1
		System.out.println(map.size());
		map.put(549, "549"); // 2 2 2
		System.out.println(map.size());
		map.put(549, "549"); // 3 2 2
		System.out.println(map.size());
		// 0
		// 1
		// 2
		// 3 <-
		// 4
	}

}
