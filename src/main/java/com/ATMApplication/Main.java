package com.ATMApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    static ApplicationContext context ;
    public static void main(String[] args) {

        UserDao userDao;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

/*            System.out.println("Enter Username");
            String name = sc.nextLine();

            System.out.println("Enter User-balance");
            double bal = sc1.nextDouble();

            System.out.println("Enter User-atmPIN");
            int pin = sc1.nextInt();;

            System.out.println("Enter User-mobileNumber");
            long mobNumber = sc1.nextLong();

            context = new ClassPathXmlApplicationContext("Beans.xml");
            System.out.println("You entered:"+name+","+bal+","+pin+","+mobNumber);
            userDao = (UserDao) context.getBean("userDao");
            User user = new User(name,bal,pin,mobNumber);
            userDao.insert(user);*/

            //Question 2
/*
            context = new ClassPathXmlApplicationContext("Beans.xml");
            userDao = (UserDao) context.getBean("userDao");
            User user = new User("ankit",7845612,1234,7065570755l);
            userDao.insert(user);
            userDao.withdrawal(user,5000);
*/

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
        AlertForGeneratingSMS alertForGeneratingSMS = ctx.getBean(AlertForGeneratingSMS.class);
        userDao = (UserDao) ctx.getBean("userDao");
        User user = new User("rohit",1000000,1234,9350039522l);
        userDao.insert(user);
        userDao.changeATMPIN(user, alertForGeneratingSMS.acceptPIN(1016));
        userDao.changeMobileNumber(user,9555520053l);
    }
}
