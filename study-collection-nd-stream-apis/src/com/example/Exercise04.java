package com.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Exercise04 {

	public static void main(String[] args) {
		var myData = new HashMap<String,Integer>();
		var tsMyData = Collections.synchronizedMap(myData);
		var hpTsMyData= new ConcurrentHashMap<String,Integer>();
	}

}
