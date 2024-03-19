package com.example.application;

import java.lang.reflect.Proxy;

import com.example.aspects.AuditingHandler;
import com.example.aspects.CachingHandler;
import com.example.service.Calculator;
import com.example.service.StandardCalculator;

public class CalculatorApplication {

	public static void main(String[] args) {
		Calculator calculator = new StandardCalculator();
		var clazz = calculator.getClass();
		Calculator proxy = (Calculator) 
			Proxy.newProxyInstance(
				clazz.getClassLoader(), 
				clazz.getInterfaces(),
				new AuditingHandler(calculator)
			);
		proxy = (Calculator) 
				Proxy.newProxyInstance(
						clazz.getClassLoader(), 
						clazz.getInterfaces(),
						new CachingHandler(proxy)
						);
		System.out.println("3 + 5: %f".formatted(proxy.add(3, 5)));
		System.out.println("3 + 5: %f".formatted(proxy.add(3, 5)));
		System.out.println("3 + 2: %f".formatted(proxy.add(3, 2)));
		System.out.println("3 + 4: %f".formatted(proxy.add(3, 4)));
		System.out.println("3 + 5: %f".formatted(proxy.add(3, 5)));

	}

}
