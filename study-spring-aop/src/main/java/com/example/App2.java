package com.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.service.impl.SimpleCalculator;

public class App2 {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = new AnnotationConfigApplicationContext("com.example.config");
		var calc = container.getBean(SimpleCalculator.class);
		// CG -> Instrumentation Library
		// com.example.service.impl.SimpleCalculator$$SpringCGLIB$$0
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
