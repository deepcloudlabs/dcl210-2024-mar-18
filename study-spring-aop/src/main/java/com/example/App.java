package com.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.service.Calculator;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = new AnnotationConfigApplicationContext("com.example.config");
		Calculator calc = container.getBean(Calculator.class);
		// jdk.proxy2.$Proxy22 -> JDK's Proxy-based AOP
		System.out.println(calc.getClass().getName());
		calc.add(3, 5);
		calc.sub(7, 4);
		calc.mul(3, 2);
		calc.div(5, 3);
		try {
			calc.div(4, 0);
		} catch (Exception e) {
		}
		container.close();
	}
}
