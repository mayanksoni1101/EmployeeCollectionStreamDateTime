# Java 8 Stream API - Employee Date & Time Processing

A Java application demonstrating real-world data manipulation using the **Java 8 Stream API**, **`LocalDate`**, **`LocalTime`**, **`Period`**, and **`Duration`** classes.

---

## 📌 Project Overview

This project showcases how to process employee date of joining, work hours, login/logout timings, experience calculations, and company-wise metrics using Java Functional Programming.

---

## 📁 Repository Structure

```text
src/
 └── org/
      └── jsp/
           └── employeeDateTime/
                ├── Employee.java                # Employee POJO Model
                ├── EmployeeListDatePrgrm.java   # Date-based Stream queries
                └── EmployeeListTimePrgrm.java   # Time-based Stream queries
```

---

## 🛠️ Components

### 1. `Employee.java`
Model class representing employee details:
* `name` (*String*)
* `company` (*String*)
* `salary` (*double*)
* `joining` (*LocalDate*)
* `logIn` (*LocalTime*)
* `logOut` (*LocalTime*)

### 2. `EmployeeListDatePrgrm.java`
Demonstrates Stream operations targeting date attributes:
* Grouping employees by joining year and counting total hires
* Calculating years of experience using `Period.between()`
* Filtering by quarters, specific months, or specific days of the week
* Finding the senior-most, junior-most, or $N^{\text{th}}$ senior employee
* Calculating total salary payouts aggregated by joining year

### 3. `EmployeeListTimePrgrm.java`
Demonstrates Stream operations targeting time attributes:
* Sorting employees by login/logout times
* Calculating work durations using `Duration.between()`
* Filtering employees by minimum/maximum working hours
* Finding company-wise earliest/latest logouts and logins
* Grouping employees by company and sorting by duration

---

## 🚀 How to Run

1. **Prerequisites**: Ensure Java 8 or higher is installed.
2. **Compile**:
   ```bash
   javac org/jsp/employeeDateTime/*.java
   ```
3. **Execute Date Queries**:
   ```bash
   java org.jsp.employeeDateTime.EmployeeListDatePrgrm
   ```
4. **Execute Time Queries**:
   ```bash
   java org.jsp.employeeDateTime.EmployeeListTimePrgrm
   ```

---

## 💡 Key Java Features Used
* `java.time.LocalDate` & `java.time.LocalTime`
* `java.time.Period` & `java.time.Duration`
* `java.util.stream.Collectors` (`groupingBy`, `counting`, `maxBy`, `minBy`, `summingDouble`)
* Lambda Expressions & Method References (`System.out::println`)
