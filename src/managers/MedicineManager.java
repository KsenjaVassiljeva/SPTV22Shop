/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Medicine;
import entity.Manufacturer;
import java.util.List;
import java.util.Scanner;
import tools.InputProtection;

public class MedicineManager {

    private final Scanner scanner;

    public MedicineManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public Medicine addMedicine() {
        System.out.println("----- Add Medicine -----");
        Medicine medicine = new Medicine();
        System.out.print("Enter name: ");
        medicine.setName(scanner.nextLine());
        System.out.print("Enter price: ");
        medicine.setPrice(InputProtection.doubleInput(0.01, Double.MAX_VALUE));
        System.out.print("Enter quantity: ");
        medicine.setQuantity(InputProtection.intInput(0, Integer.MAX_VALUE));
        System.out.print("Enter manufacturer: ");
        String manufacturerName = scanner.nextLine();
        medicine.setManufacturer(new Manufacturer(manufacturerName));

        System.out.println("Added medicine: " + medicine.toString());
        return medicine;
    }

    public void printListMedicines(List<Medicine> medicines) {
        System.out.println("----- List Medicines -----");
        for (int i = 0; i < medicines.size(); i++) {
            System.out.printf("%d. %s%n",
                    i + 1,
                    medicines.get(i).getName()
            );
        }
    }
}
