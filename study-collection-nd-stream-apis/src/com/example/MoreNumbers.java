package com.example;

import java.util.HashMap;
import java.util.Map;

public class MoreNumbers {

	private Map<Integer, String> m = new HashMap<Integer, String>();

	public MoreNumbers() {
		m.put(108, "108");
		m.put(108, "108");
		m.put(549, "549");
		m.put(549, "549");
	}
  
	public static void main(String[] args) {
		MoreNumbers moreNumbers = new MoreNumbers();
		System.err.println(moreNumbers.getSize());
	}

	public int getSize() {
		return m.size();
	}

}

// 0
// 1
// 2
// 3
// 4