package org.jsp.employeeDateTime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeListTimePrgrm {
	public static void main(String[] args) {
		Employee e1 = new Employee("Mayank Soni" ,"TCS", 56000, LocalDate.of(2025, 11, 3) , LocalTime.of(9, 30) , LocalTime.of(17,30));
		Employee e2 = new Employee("Bhavya Soni" ,"Wipro", 36000, LocalDate.of(2023, 1, 1), LocalTime.of(10, 30) , LocalTime.of(19,30));
		Employee e3 = new Employee("Manu Soni" ,"Infosys", 36000, LocalDate.of(2004, 8, 12), LocalTime.of(8, 30) , LocalTime.of(18,40));
		Employee e4 = new Employee("Himanshu Pandey" ,"Wipro", 24000, LocalDate.of(2022, 4, 4), LocalTime.of(10, 15) , LocalTime.of(20,30));
		Employee e5 = new Employee("Bissu Panda" ,"TCS", 76000, LocalDate.of(2021, 2, 16), LocalTime.of(11, 15) , LocalTime.of(20,30));
		Employee e6 = new Employee("Cloud Kumar" ,"KPMG", 26000, LocalDate.of(2024, 10, 11), LocalTime.of(9, 30) , LocalTime.of(18,30));
		Employee e7 = new Employee("Badal" ,"Wipro", 51000, LocalDate.of(2017, 5, 12), LocalTime.of(9, 30) , LocalTime.of(19,30));
		Employee e8 = new Employee("Mohit Saini" ,"TCS", 39000, LocalDate.of(2023, 12, 7), LocalTime.of(10, 45) , LocalTime.of(20,45));
		Employee e9 = new Employee("Gyano" ,"Infosys", 32000, LocalDate.of(2024, 9, 24), LocalTime.of(11, 10) , LocalTime.of(20,15));
		Employee e10 = new Employee("Suda PG" ,"KPMG", 28000, LocalDate.of(2021, 11, 9), LocalTime.of(8, 30) , LocalTime.of(18,30));
		
		List<Employee> al = Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10);
		//1 . sort emp based on login
		System.out.println("-----------sort emp based on login------------");
		al.stream().sorted((o1,o2) -> o1.logIn.isAfter(o2.logIn) ? 1:-1).forEach(System.out::println);
		
		//2. sort emp based on logged out
		System.out.println("-----------sort emp based on logout------------");
		al.stream().sorted((o1,o2) -> o1.logOut.isAfter(o2.logOut) ? 1:-1).forEach(System.out::println);
		
		//3. find emp count who logged in after 9
		System.out.println("----------- emp count who logged in after 9------------");
		System.out.println(al.stream().filter(emp->emp.logIn.isAfter(LocalTime.of(9, 0))).collect(Collectors.counting()));
		
		//4. find emp who logged out after last person
		System.out.println("-----------emp who logged out after last person------------");
		al.stream().sorted((o1,o2) -> o2.logIn.isAfter(o1.logIn) ? 1:-1).limit(2).skip(1).forEach(System.out::println);
		
		//5.print emp who worked 5 to 9 hours
		System.out.println("-----------emp who worked 5 to 9 hours------------");
		al.stream().filter(e->Duration.between(e.logIn, e.logOut).toHours() >= 5 && Duration.between(e.logIn, e.logOut).toHours() <=9).forEach(System.out::println);
		
		//6. emp who worked less than 9 hours
		System.out.println("-----------emp who worked less than 9 hours------------");
		al.stream().filter(e->Duration.between(e.logIn, e.logOut).toHours() <=9).forEach(System.out::println);
		
		//7. emp who worked Minimum 9 hours
		System.out.println("-----------emp who worked minimum 9 hours------------");
		al.stream().filter(e->Duration.between(e.logIn, e.logOut).toHours() ==9).forEach(System.out::println);
		
		//8. emp who worked more than 9 hours
		System.out.println("-----------emp who worked more than 9 hours------------");
		al.stream().filter(e->Duration.between(e.logIn, e.logOut).toHours() >=9).forEach(System.out::println);
		
		//9. print emp with comma separated those who logged out between 6:30 to 7:30
		System.out.println("----------- emp with comma separated those who logged out between 6:30 to 7:30 ------------");
		al.stream().filter(emp->emp.logOut.isAfter(LocalTime.of(18, 30)) && emp.logOut.isBefore(LocalTime.of(19, 30))).map(e->e.name).forEach(System.out::println);
		
		//10. print emp based on logged out last to early
		System.out.println("-----------emp who logged out last to early------------");
		al.stream().sorted((o1,o2) -> o2.logOut.isAfter(o1.logOut) ? 1:-1).forEach(System.out::println);
		
		
		//11.company wise who logged out first
		System.out.println("-----------company wise who logged out first------------");
		al.stream().collect(Collectors.groupingBy(e->e.company , Collectors.maxBy((o1,o2) -> o1.logOut.isBefore(o2.logOut) ? 1:-1))).forEach((k,v) ->System.out.println(k + " -> "+v));
		
		//12.company wise who logged in last
		System.out.println("-----------company wise who logged in last------------");
		al.stream().collect(Collectors.groupingBy(e->e.company , Collectors.maxBy((o1,o2) -> o1.logIn.isAfter(o2.logIn) ? 1:-1))).forEach((k,v) ->System.out.println(k + " -> "+v));
		
		//13.company wise who logged out last
		System.out.println("-----------company wise who logged out last------------");
		al.stream().collect(Collectors.groupingBy(e->e.company , Collectors.maxBy((o1,o2) -> o1.logOut.isAfter(o2.logOut) ? 1:-1))).forEach((k,v) ->System.out.println(k + " -> "+v));
		
		//14. company wise who logged in first
		System.out.println("-----------company wise who logged in first------------");
		al.stream().collect(Collectors.groupingBy(e->e.company , Collectors.minBy((o1,o2) -> o1.logIn.isAfter(o2.logIn) ? 1:-1))).forEach((k,v) ->System.out.println(k + " -> "+v));
		
		//15.TCS emp who logged out before 6
		System.out.println("-----------TCS emp who logged out before 6------------");
		al.stream().filter(e->e.company.equalsIgnoreCase("tcs") && e.logOut.getHour() < 18).forEach(System.out::println);
		
		//16.company wise sort the employee who logged in first	
		System.out.println("-----------company wise sort the employee who logged in first------------");
		al.stream().sorted((o1,o2) -> o1.logIn.isAfter(o2.logIn) ? 1:-1).collect(Collectors.groupingBy(e->e.company)).forEach((k,v) -> System.out.println(k +" -> " +v));	
		
		//17.company wise sort the employee who logged out last
		System.out.println("-----------company wise sort the employee who logged ou lastt------------");
		al.stream().sorted((o1,o2) -> o2.logOut.isAfter(o1.logOut) ? 1:-1).collect(Collectors.groupingBy(e->e.company)).forEach((k,v) -> System.out.println(k +" -> " +v));	
				
		//18.company wise sort the emp based on number of working hours in descending
		System.out.println("-----------company wise sort the emp based on number of working hours in descending------------");
		al.stream().sorted((o1,o2) ->(int)Duration.between(o1.logIn, o1.logOut).toHours() - (int)Duration.between(o2.logIn, o2.logOut).toHours()).collect(Collectors.groupingBy(e->e.company)).forEach((k , v) -> System.out.println(k + " " + v));
		
		//19. company wise count how many emp worked minimum 9 hours
		System.out.println("-----------company wise count how many emp worked minimum 9 hours------------");
		al.stream().filter(e->Duration.between(e.logIn, e.logOut).toHours() >=9).collect(Collectors.groupingBy(e->e.company)).forEach((k,v)->System.out.println(k + " -> " +v.size()));
		
		//20.
	}
}
