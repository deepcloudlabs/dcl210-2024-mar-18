package com.example.application;

import com.example.model.LotteryNumbersModel;
import com.example.service.RandomNumberGeneratorService;

public class LotteryApplication {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		var randomNumberGeneratorService = new RandomNumberGeneratorService();
		var lotteryNumbers = new LotteryNumbersModel();
		randomNumberGeneratorService.generate(lotteryNumbers);
		System.out.println(lotteryNumbers.getNumbers());
	}

}
