package com.example.model;

import java.util.List;

import com.example.service.RandomNumber;

public class LotteryNumbersModel {
	// annotation -> metadata
	@RandomNumber(min=1,max=100,size=16,sorted=true,distinct=true)
	private List<Integer> numbers;

	public List<Integer> getNumbers() {
		return numbers;
	}
	
}
