package com.developerhut.net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class NewFunctionalInterfacesAndLambdaDemo {

	public static void main(String[] args) {

		Supplier<String> supplier = () -> {return "Bob";};
		
		System.out.println("With Lambda Get Name : "+supplier.get());
		
	}
	
	public static void main_v7(String[] args) {

		Supplier<String> supplier = new Supplier<String>() {

			@Override
			public String get() {
				return "Adam";
			}
			
		};
		
		System.out.println("Get Name : "+supplier.get());
		
	}
	
	public static void main_v6(String[] args) {

		List<String> userList = new ArrayList<>(Arrays.asList("Adam", "Bob", "Tom", "Kathey"));

		Stream<String> filter = userList.stream().filter(name -> {return name.contains("a");});
		
		filter.forEach((name) -> {System.out.println("With Lambda Name : "+name);});
	}
	
	public static void main_v5(String[] args) {

		List<String> userList = new ArrayList<>(Arrays.asList("Adam", "Bob", "Tom", "Kathey"));

		Stream<String> filter = userList.stream().filter(new Predicate<String>() {

			@Override
			public boolean test(String name) {
				return name.contains("a");
			}
			
		});
		
		filter.forEach((name) -> {System.out.println("Name : "+name);});
	}
	
	public static void main_v4(String[] args) {

		List<String> userList = new ArrayList<>(Arrays.asList("Adam", "Bob", "Tom", "Kathey"));

		Stream<String> map = userList.stream().map((originalName) -> {return originalName.toUpperCase();});
		
		map.forEach((updatedName) -> {System.out.println("With Lambda Updated Name : "+updatedName);});
	}
	
	public static void main_v3(String[] args) {

		List<String> userList = new ArrayList<>(Arrays.asList("Adam", "Bob", "Tom", "Kathey"));

		Stream<String> map = userList.stream().map(new Function<String, String>() {

			@Override
			public String apply(String originalName) {
				return originalName.toUpperCase();
			}
			
		});
		
		map.forEach((updatedName) -> {System.out.println("Updated Name : "+updatedName);});
	}
	
	public static void main_v2(String[] args) {

		List<String> userList = new ArrayList<>(Arrays.asList("Adam", "Bob", "Tom", "Kathey"));

		userList.forEach((name) -> {System.out.println("With Lambda Name : "+name);});
	}
	
	public static void main_v1(String[] args) {

		List<String> userList = new ArrayList<>(Arrays.asList("Adam", "Bob", "Tom", "Kathey"));

		userList.forEach(new Consumer<String>() {

			@Override
			public void accept(String name) {
				System.out.println("Name : "+name);
			}
			
		});
	}
	
}
