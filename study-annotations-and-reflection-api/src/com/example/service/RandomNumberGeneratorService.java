package com.example.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RandomNumberGeneratorService {
	public void generate(Object o) throws IllegalArgumentException, IllegalAccessException {
		var clazz = o.getClass();
		for (var field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(RandomNumber.class)) {
				var randomNumber = field.getDeclaredAnnotation(RandomNumber.class);
				var numbers = generateRandomNumbers(randomNumber);
				field.setAccessible(true);
				field.set(o, numbers);
				field.setAccessible(false);
			}
		}
	}

	private List<Integer> generateRandomNumbers(RandomNumber randomNumber) {
		IntStream stream = ThreadLocalRandom.current().ints(randomNumber.min(), randomNumber.max());
		if (randomNumber.distinct())
			stream = stream.distinct();
		stream = stream.limit(randomNumber.size());
		if (randomNumber.sorted())
			stream = stream.sorted();
		return stream.boxed().toList();
	}
}
