package com.example.application;

import com.example.model.LotteryNumbersModel;

public class LotteryApplication {

	public static void main(String[] args) {
		var lotteryNumbers = new LotteryNumbersModel();
		System.out.println(lotteryNumbers.getNumbers());
	}

}
