/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

/**
 *
 * @author User
 */

import entity.Customer;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    private final Scanner scanner;

    public CustomerManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public Customer addCustomer() {
        Customer customer = new Customer();
        System.out.println("----- Add customer -----");
        System.out.print("Firstname: ");
        customer.setFirstname(scanner.nextLine());
        System.out.print("Lastname: ");
        customer.setLastname(scanner.nextLine());
        System.out.print("Phone: ");
        customer.setPhoneNumber(scanner.nextLine());
        System.out.println("New customer added!");
        return customer;
    }

    public void printListCustomers(List<Customer> customers) {
        System.out.println("----- List customers -----");
        for (int i = 0; i < customers.size(); i++) {
            System.out.printf("%d. %s %s. (%s)%n",
                    i + 1,
                    customers.get(i).getFirstname(),
                    customers.get(i).getLastname(),
                    customers.get(i).getPhoneNumber()
            );
        }
    }
}

