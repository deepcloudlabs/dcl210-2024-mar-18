package com.example.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public @interface RandomNumber {
	// primitives: byte, short, int, long, float, double, boolean, char, String
	// wrapper   : Byte, Short, Integer, Long, Float, Double, Boolean, Character
	// array version: byte[], Byte[], char[], Character[]
	// enum: SHIRT_SIZE
	// array version: SHIRT_SIZE[]
	// annotation
	// annotation array
	// Class: Class<?> type();
	// Array of Class: Class<?>[] types();
	
	int min();

	int max();

	int size();

	boolean sorted();

	boolean distinct();

}
enum SHIRT_SIZE {XS, S, M, L, XL}
