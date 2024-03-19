package com.example.animals.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Predicate;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Pet;
import com.example.animals.domain.Spider;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	public static void main(String[] args) {
		// Take a list of wild animals
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		var wildAnimals = new ArrayList<>();
		for (var animal : animals) { // iterator
			if (! (animal instanceof Pet))
				wildAnimals.add(animal);
		}
		Predicate<Animal> isPet = Pet.class::isInstance;
		var vahsiHayvanlar = animals.stream()                // Stream<Animal>
				                    .parallel()
				                    .filter(isPet.negate())  // Stream<Animal>
				                    .toList();               // List<Animal>
		var spliter = animals.spliterator();
		var firstHalf = spliter.trySplit();
		// data parallelism: collection 
		// Fork/Join Framework: since java se 7 -> concurrency api
		// Stream API -- uses --> ForkJoin Framework
	}
}
