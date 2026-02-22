// Exercise 3.13 EmployeeTest.java

import java.util.Scanner;

public class EmployeeTest {


  public static void main (String[] args){

    Employee employee1 = new Employee("Rexzy", "Bate", 2500);
    Employee employee2 = new Employee("Rexzy","Beching", 3000);

    System.out.printf("%n1. %s %s:%n - Salary: %f", employee1.getFirstName(), employee1.getLastName(), employee1.getMonthlySalary());

      System.out.printf("%n%n2. %s %s:%n - Salary: %f%n", employee2.getFirstName(), employee2.getLastName(), employee2.getMonthlySalary());

      double newSalary = employee1.getMonthlySalary();

      newSalary = (newSalary * 10 / 100) + employee1.getMonthlySalary();
      employee1.setMonthlySalary(newSalary);

      System.out.printf("%n1. %s %s:%n - Salary: %f", employee1.getFirstName(), employee1.getLastName(), employee1.getMonthlySalary());

      
      newSalary = employee2.getMonthlySalary();

      newSalary = (newSalary * 10 / 100) + employee2.getMonthlySalary();
      
      employee2.setMonthlySalary(newSalary);

      System.out.printf("%n%n2. %s %s:%n - Salary: %f%n", employee2.getFirstName(), employee2.getLastName(), employee2.getMonthlySalary());



  }
}
