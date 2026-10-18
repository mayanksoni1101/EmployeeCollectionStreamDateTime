package org.jsp.employeeDateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeListDatePrgrm {
	public static void main(String[] args) {
		Employee e1 = new Employee("Mayank Soni" ,"TCS", 56000, LocalDate.of(2025, 11, 3) , LocalTime.of(9, 30) , LocalTime.of(18,30));
		Employee e2 = new Employee("Bhavya Soni" ,"Wipro", 36000, LocalDate.of(2023, 1, 1), LocalTime.of(10, 30) , LocalTime.of(19,30));
		Employee e3 = new Employee("Manu Soni" ,"Infosys", 36000, LocalDate.of(2004, 8, 12), LocalTime.of(8, 30) , LocalTime.of(18,30));
		Employee e4 = new Employee("Himanshu Pandey" ,"Wipro", 24000, LocalDate.of(2022, 4, 4), LocalTime.of(10, 15) , LocalTime.of(20,30));
		Employee e5 = new Employee("Bissu Panda" ,"TCS", 76000, LocalDate.of(2021, 2, 16), LocalTime.of(11, 15) , LocalTime.of(20,30));
		Employee e6 = new Employee("Cloud Kumar" ,"KPMG", 26000, LocalDate.of(2024, 10, 11), LocalTime.of(8, 30) , LocalTime.of(18,30));
		Employee e7 = new Employee("Badal" ,"Wipro", 51000, LocalDate.of(2017, 5, 12), LocalTime.of(9, 30) , LocalTime.of(19,30));
		Employee e8 = new Employee("Mohit Saini" ,"TCS", 39000, LocalDate.of(2023, 12, 7), LocalTime.of(10, 45) , LocalTime.of(20,45));
		Employee e9 = new Employee("Gyano" ,"Infosys", 32000, LocalDate.of(2024, 9, 24), LocalTime.of(11, 10) , LocalTime.of(20,15));
		Employee e10 = new Employee("Suda PG" ,"KPMG", 28000, LocalDate.of(2021, 11, 9), LocalTime.of(8, 30) , LocalTime.of(18,30));
		
		List<Employee> al = Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10);
		
		//1. employee joined in each year
		System.out.println("---------employee joined in each year----------------------------");
		al.stream().collect(Collectors.groupingBy(e->e.joining.getYear() , Collectors.counting())).entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
		
		//2. number of experience based on joining date
		System.out.println("---------number of experience based on joining date----------------------------");
		al.stream().forEach(e-> System.out.println(e +  " Experience " +  Period.between(e.joining, LocalDate.now()).getYears() + " Years"));
		
		//3. employee joined in 2024
		System.out.println("---------employee joined in 2024----------------------------");
		al.stream().filter(e->e.joining.getYear() <= 2024).forEach(System.out::println);
		
		//4. employee joined after 2023
		System.out.println("---------employee joined after 2023----------------------------");
		al.stream().filter(e->e.joining.getYear() > 2023).forEach(System.out::println);
		
		//5. find the year employee joined in
		System.out.println("--------- year employee joined in ----------------------------");
		al.stream().forEach(e -> System.out.println(e.name + " Joining Year :  " + e.joining.getYear()));
		
		//6. employee joined in february
		System.out.println("---------employee joined in february----------------------------");
		al.stream().filter(e->e.joining.getMonthValue() == 2).forEach(System.out::println);
		
		//7. employee joined 4th day of the month
		System.out.println("---------employee joined 4th day of the month----------------------------");
		al.stream().filter(e->e.joining.getDayOfMonth() == 4).forEach(System.out::println);
		
		//8. month in which employee joined in words
		System.out.println("---------month in which employee joined in words----------------------------");
		al.stream().forEach(e -> System.out.println(e.name + "  joined in " + e.joining.getMonth() + " ."));
		
		//9. employee joined in first quarter of the year
		System.out.println("---------employee joined in first quarter of the year----------------------------");
		al.stream().filter(e->e.joining.getMonthValue() <= 3).forEach(System.out::println);
		
		//10. employee joined in third quarter of the year
		System.out.println("---------employee joined in third quarter of the year----------------------------");
		al.stream().filter(e->e.joining.getMonthValue() >= 7 && e.joining.getMonthValue() <= 9).forEach(System.out::println);
		
		//11. employee joined on wednesday
		System.out.println("-----------employee joined on wednesday-------------");
		al.stream().filter(e->e.joining.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)).forEach(System.out::println);
		
		//12. employee who served minimum 5 years
		System.out.println("---------employee who served minimum 5 years----------------------------");
		al.stream().filter(e->Period.between(e.joining, LocalDate.now()).getYears() >=5).forEach(System.out::println);
		
		//13. employee joined between 2000 and 2023
		System.out.println("---------employee joined between 2000 and 2023----------------------------");
		al.stream().filter(e->e.joining.getYear()>=2000 && e.joining.getYear() <= 2023).forEach(System.out::println);

		//14. find senior most employee
		System.out.println("---------senior most employee----------------------------");
		System.out.println(al.stream().max((o1,o2) -> o1.joining.isAfter(o2.joining) ? -1 :1).get());
		
		//15. find junior most employee
		System.out.println("---------senior most employee----------------------------");
		System.out.println(al.stream().min((o1,o2) -> o1.joining.isAfter(o2.joining) ? -1 :1).get());
		
		//16. each year how many employee joined and total salary to be paid
		System.out.println("---------each year how many employee joined and total salary to be paid----------------------------");
		al.stream().collect(Collectors.groupingBy(e->e.joining.getYear())).forEach((k,v) -> System.out.println(k + " => " +v.size() + " => " + v.stream().collect(Collectors.summingDouble(e->e.salary))));	
		
		//17. find nth senior employee
		System.out.println("---------nth senior employee----------------------------");
		int n = 3;
		al.stream().sorted((o1,o2) -> o1.joining.isAfter(o2.joining) ? -1 :1).limit(n).skip(n-1).forEach(System.out::println);
	}
}
