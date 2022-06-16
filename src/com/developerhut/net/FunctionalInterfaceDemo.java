package com.developerhut.net;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		MyFunctionalInterface.print("msg");
		
		MyFunctionalInterface intr = new MyFunctionalInterface() {
			
			@Override
			public void method1(String str) {
				// TODO Auto-generated method stub
			}
		};
		intr.log("msg");
				
	}

}

@FunctionalInterface
interface MyFunctionalInterface {

	void method1(String str);

	static void print(String msg) {
		System.out.println("print : " + msg);
	}

	default void log(String msg) {
		System.out.println("log : " + msg);
	}

}