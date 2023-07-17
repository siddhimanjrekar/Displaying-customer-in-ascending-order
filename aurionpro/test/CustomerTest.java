package com.aurionpro.test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.model.Customer;
public class CustomerTest {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        
        for (int i = 1; i <= 10; i++) {
            System.out.println("Enter details for Customer " + i);
            System.out.print("Customer ID: ");
            int custId = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Name: ");
            String name = scanner.nextLine();

            String email;
            while (true) {
                System.out.print("Email: ");
                email = scanner.nextLine();
                if (isValidEmail(email)) {
                    break;
                } else {
                    System.out.println("Invalid email format. Please try again.");
                }
            }

            System.out.print("Password: ");
            String password = scanner.nextLine();

            customers.add(new Customer(custId, name, email, password));
        }

        
        System.out.println("\nCustomers:\n");
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getCustId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Password: " + customer.getPassword());
            System.out.println("------------------------");
        }

       
        Collections.sort(customers, Comparator.comparing(Customer::getName));

        
        System.out.println("\nCustomers sorted by name:\n");
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getCustId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Password: " + customer.getPassword());
            System.out.println("------------------------");
        }
    }

  
    private static boolean isValidEmail(String email) {
      
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

	
}
