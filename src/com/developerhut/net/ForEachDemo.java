package com.developerhut.net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachDemo {

	public static void main(String[] args) {
		List<User> userList = new ArrayList<>();
		userList.add(new User(1200));
		userList.add(new User(3200));
		userList.add(new User(5600));
		userList.add(new User(1700));
		
		TaxCalculationConsumer action = new TaxCalculationConsumer();
		userList.forEach(action);
		
		System.out.println("-------------");
		for (User user : userList) {
			System.out.println(user.getAmount()+" : "+user.getTaxAmt());			
		}
	}
	
	public static void main_v4(String[] args) {
		List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
	}

	public static void main_v3(String[] args) {

		List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		myList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("Value : " + t);
			}

		});

	}

	public static void main_v2(String[] args) {

		List<Integer> myList = new ArrayList<>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);

		for (Integer integer : myList) {
			System.out.println("Value : " + integer);
		}
	}

	public static void main_v01(String[] args) {

		List<Integer> myList = new ArrayList<>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);

		Iterator<Integer> iterator = myList.iterator();
		while (iterator.hasNext()) {
			System.out.println("Value : " + iterator.next());
		}

	}

}

class MyConsumer implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		System.out.println("Value : " + t);
	}

}

class User {

	private double amount;

	private double taxAmt;

	public User(double amount) {
		super();
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(double taxAmt) {
		this.taxAmt = taxAmt;
	}

}

class TaxCalculationConsumer implements Consumer<User> {

	@Override
	public void accept(User user) {
		double calculatedTaxAmt = 10 + user.getAmount();
		user.setTaxAmt(calculatedTaxAmt);
	}
	
}