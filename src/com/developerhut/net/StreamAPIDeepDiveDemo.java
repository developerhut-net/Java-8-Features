package com.developerhut.net;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIDeepDiveDemo {

	//Collectors
	public static void main(String[] args) {

		List<Employee> employeeList = getEmployeeList();
		
		//Collect into List
		/*List<String> collect = employeeList.stream()
			.limit(3)
			.map(employee-> {return employee.getName();})
			.collect(Collectors.toList());*/
		
		//Collect into Set
		/*Set<String> set = employeeList.stream()
			.limit(3)
			.map(employee-> {return employee.getName();})
			.collect(Collectors.toSet());*/
		
		
		//Collect into Map
		/*Function<Employee, String> keyMapper =  e -> e.getName();
		Function<Employee, Employee> valueMapper = e -> e;
		
		Map<String, Employee> map = employeeList.stream()
				.limit(3)
				.collect(Collectors.toMap(keyMapper, valueMapper));*/
		
		//Collect into String with delimiter ","
		/*String collect = employeeList.stream()
			.limit(3)
			.map(employee-> {return employee.getName();})
			.collect(Collectors.joining(","));
		System.out.println(collect);*/
		
		//Group by
		/*Map<String, List<Employee>> collect = employeeList.stream()
			.collect(Collectors.groupingBy(emp->emp.getDept()));
		collect.forEach((deptName, employees) -> {
			System.out.println(deptName + " - " + employees.size());
		});*/
		
		//Count the employees in each dept
		/*Map<String, Long> collect = employeeList.stream()
				.collect(Collectors.groupingBy(emp->emp.getDept(),Collectors.counting()));
		
		collect.forEach((deptName, count) -> {
			System.out.println(deptName + " - " + count);});*/
		
		//---------------------------
		//reduce()
		
		
		BinaryOperator<Integer> accumulator = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				return t+u;
			}
		};
		Optional<Integer> reduce = employeeList.stream()
			.map(emp -> emp.getSalary())
			.reduce(accumulator);
		System.out.println(reduce);
		
	}
	
	public static void main_v3(String[] args) {

		List<Employee> employeeList = getEmployeeList();
		
		//Highest earning employee with status active
		employeeList.stream()
			.sorted((e1,e2)->{return e2.getSalary() - e1.getSalary();})
			.filter(emp -> {return emp.isActive();})
			.limit(3)
			.map(employee-> {return employee.getName();})
			.forEach(employee -> {System.out.println(employee);});
		
	}

	public static void main_v2(String[] args) {

		List<Employee> employeeList = getEmployeeList();

		// 3 highest earning employees
		List<Employee> copy = new ArrayList<>(employeeList);
		copy.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				return e2.getSalary() - e1.getSalary();
			}

		});

		// copy.forEach(employee -> System.out.println(employee));

		for (int i = 0; i < 3; i++) {
			Employee e = copy.get(i);
			System.out.println(e);
		}
	}

	public static void main_v1(String[] args) {

		// Find minimum number in array
		int[] numbers = { 5, 2, 1, 4, 6, 8, 7, 3 };

		/*
		 * int min = numbers[0]; for (int i = 0; i < numbers.length; i++) { if(min >
		 * numbers[i]) { min = numbers[i]; } } System.out.println("Minimum : "+min);
		 */

		System.out.println("Min : " + IntStream.of(numbers).min().getAsInt());
		System.out.println("Max : " + IntStream.of(numbers).max().getAsInt());
		System.out.println("Avg : " + IntStream.of(numbers).average().getAsDouble());
		System.out.println("Count : " + IntStream.of(numbers).count());
		System.out.println("Sum : " + IntStream.of(numbers).sum());
		System.out.println("Find : " + IntStream.of(numbers).findFirst());

		// Find distinct element
		/*
		 * IntStream.of(numbers) .limit(3) .distinct() .sorted() .forEach(value ->
		 * {System.out.println(value);});
		 */

		// Sort Asc/Desc
		/*
		 * IntStream.of(numbers) .boxed() .sorted(Collections.reverseOrder())
		 * .forEach(value -> {System.out.println(value);});
		 */

		// Find Even number
		/*
		 * IntStream.of(numbers) .boxed() .filter(n->n%2==0) .sorted() .forEach(value ->
		 * {System.out.println(value);});
		 */

		// Find Odd number
		/*
		 * IntStream.of(numbers) .boxed() .filter(n->(n%2)!=0) .sorted() .forEach(value
		 * -> {System.out.println(value);});
		 */

		// Create Stream
		// IntStream.range(1, 10).forEach(value -> {System.out.println(value);});;
		// IntStream.rangeClosed(1, 10).forEach(value -> {System.out.println(value);});;
		// IntStream.generate(..);

		// Consume Method
		IntStream.range(1, 10).forEach(value -> {
			System.out.println(value);
		});
		;
		IntStream.range(1, 10).toArray();
		IntStream.range(1, 10).boxed();
		IntStream.range(1, 10).boxed().collect(Collectors.toList());
		IntStream.range(1, 10).anyMatch(num -> num % 2 == 0);
		IntStream.range(1, 10).allMatch(num -> num % 2 == 0);

	}

	private static List<Employee> getEmployeeList() {

		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Employee("Zack", false, 9800, "IT"));
		employeeList.add(new Employee("Bob", true, 8200, "Engineering"));
		employeeList.add(new Employee("Jack", false, 5000, "IT"));
		employeeList.add(new Employee("Adam", true, 7500, "HR"));
		employeeList.add(new Employee("James", false, 8000, "IT"));
		employeeList.add(new Employee("David", true, 8300, "HR"));
		employeeList.add(new Employee("Joe", false, 7900, "Engineering"));
		employeeList.add(new Employee("Celina", true, 9900, "HR"));

		return employeeList;
	}
}
