package com.developerhut.net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LamdaExpressionDemo {
	
	public static void main(String[] args) {
		
		List<String> emailList = new ArrayList<>(Arrays.asList("john@gmail.com","berry@yahoo.com","jenny@hotmail.com"));
		
		//	method args		->		code block
		Consumer<? super String> action = (email) -> {System.out.println("With Lambda : "+email);};
		emailList.forEach(action);
		
	}

	public static void main_v1(String[] args) {
		
		List<String> emailList = new ArrayList<>(Arrays.asList("john@gmail.com","berry@yahoo.com","jenny@hotmail.com"));
		
		Consumer<String> action = new Consumer<String>() {

			@Override
			public void accept(String email) {
				System.out.println("Without Lambda : "+email);
			}
			
		};
		emailList.forEach(action);
	}
	
}
