package com.developerhut.net;

@FunctionalInterface
public interface MyInterface {

	void method1(String arg);

	default void log(String message) {
		System.out.println("Log : "+message);
	}
	
	static void print(String message) {
		System.out.println("Print : "+message);
	}
	
}
