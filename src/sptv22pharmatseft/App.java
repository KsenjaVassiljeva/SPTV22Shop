/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptv22pharmatseft;

/**
 *
 * @author User
 */
import managers.SaveManager;
import managers.SaleManager;
import managers.CustomerManager;
import entity.Medicine;
import entity.Sale;
import entity.Customer;
import java.util.List;
import java.util.Scanner;
import managers.MedicineManager;
import tools.InputProtection;

public class App {
    private final Scanner scanner; 
    private List<Medicine> medicines;
    private List<Customer> customers;
    private List<Sale> sales;
    private final MedicineManager medicineManager;
    private final CustomerManager customerManager;
    private final SaleManager saleManager;
    private final SaveManager saveManager;

    public App() {
        this.scanner = new Scanner(System.in);
        this.saveManager = new SaveManager();
        this.medicines = saveManager.loadMedicines();
        this.customers = saveManager.loadCustomers();
        this.sales = saveManager.loadSales();
        this.medicineManager = new MedicineManager(scanner);
        this.customerManager = new CustomerManager(scanner);
        this.saleManager = new SaleManager(scanner, customerManager, medicineManager);
    }

    public void run() {
        boolean repeat = true;
        System.out.println("------- Pharmacy -------");
        do {
            System.out.println("List tasks:");
            System.out.println("0. Exit");
            System.out.println("1. Add new medicine");
            System.out.println("2. Print list medicines");
            System.out.println("3. Add new customer");
            System.out.println("4. Print list customers");
            System.out.println("5. Sell medicine");
            System.out.println("6. Print list sold medicines");
            System.out.println("7. Return medicine");
            System.out.println("8. Medicine rating");

            System.out.print("Enter task number: ");
            int task = InputProtection.intInput(0, 8); 
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    this.medicines.add(medicineManager.addMedicine());
                    saveManager.saveMedicines(this.medicines);
                    break;
                case 2:
                    medicineManager.printListMedicines(medicines);
                    break;
                case 3:
                    this.customers.add(customerManager.addCustomer());
                    saveManager.saveCustomers(customers);
                    break;
                case 4:
                    customerManager.printListCustomers(customers);
                    break;
                case 5:
                    this.sales.add(saleManager.sellMedicine(medicines, customers));
                    saveManager.saveSales(sales);
                    break;
                case 6:
                    saleManager.printListSoldMedicines(sales);
                    break;
                case 7:
                    saleManager.returnMedicine(sales);
                    saveManager.saveSales(sales);
                    break;
                case 8:
                    saleManager.medicineRating(this.sales);
                    break;
                default:
                    System.out.println("Select from list tasks!");
            }
            System.out.println("-----------------------");
        } while (repeat);
        System.out.println("Goodbye!");
    }
}