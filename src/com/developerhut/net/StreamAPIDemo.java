package com.developerhut.net;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPIDemo {

	public static void main(String[] args) {

		List<String> countryList = Arrays.asList("Mexico", "Brazil", "Bahamas", "Russia", 
				"Belgium", "United Kingdom", "Botswana");
		
		countryList.stream()
			.filter(country -> {return country.startsWith("B");})
			.map(country -> {return country.toUpperCase();})
			.sorted()
			.forEach(country -> {System.out.println(country);});
		
	}
	
	public static void main_v1(String[] args) {

		List<String> countryList = Arrays.asList("Mexico", "Brazil", "Bahamas", "Russia", 
				"Belgium", "United Kingdom", "Botswana");
		
		//Get all countries which starts with letter 'B' in Sorted manner and their name should be uppercase
		
		Collections.sort(countryList);
		
		for (String country : countryList) {
			if(country.startsWith("B")) {
				String updatedCountry = country.toUpperCase();
				System.out.println(updatedCountry);
			}
		}
		
	}

}
