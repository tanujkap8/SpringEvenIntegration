package com.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  //Question 1
  static String choice = "y";
  static ApplicationContext context ;
  public static void main(String[] args) {

    EmployeeDao employeeDao ;
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    while (choice == "y" || choice == "Y"){
        System.out.println("Enter Employee-id");
        int id = sc.nextInt();

        System.out.println("Enter Employee-name");
        String name = sc1.nextLine();

        System.out.println("Enter Employee-mailID");
        String mailID = sc1.nextLine();

        System.out.println("Enter Employee-salary");
        int salary = sc1.nextInt();

        if(salary > 30000){
          context = new ClassPathXmlApplicationContext("AsyncConfig.xml");
        }
          context = new ClassPathXmlApplicationContext("Beans.xml");
          System.out.println("You entered:"+id+","+name+","+mailID+","+salary);
          employeeDao = (EmployeeDao)context.getBean("employeeDao");
          Employee employee = new Employee(id,name,mailID,salary);
          employeeDao.insert(employee);
          choice = "n";
          System.out.println("Want to add more Employees??? type y");
          choice = sc2.next();
    }
  }
}
