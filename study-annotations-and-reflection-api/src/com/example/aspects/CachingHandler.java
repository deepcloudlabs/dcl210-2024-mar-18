package com.example.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CachingHandler implements InvocationHandler {
	private Map<Method,Map<Integer,Object>> METHOD_CACHE = new ConcurrentHashMap<>();
	private final Object target;
	
	public CachingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var cache = METHOD_CACHE.get(method);
		if (Objects.isNull(cache)) {
			cache = new ConcurrentHashMap<>();
			METHOD_CACHE.put(method, cache);
		}
		int hash = Objects.hash(args);
		var result = cache.get(hash);
		if (Objects.isNull(result)) {
			result = method.invoke(target, args);
			cache.put(hash, result);
		}
		return result;
	}

}
