import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Automobile auto = new Automobile("Ford", "Mustang", "Red", 2020, 10000);
        printArray(auto.listVehicle());
        System.out.println(auto.removeVehicle());
        System.out.println(auto.addVehicle("Toyota", "Camry", "Blue", 2022, 5000));
        printArray(auto.listVehicle());
        System.out.println(auto.updateVehicle("Toyota", "Camry", "Green", 2022, 6000));
        printArray(auto.listVehicle());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to print the information to a file (Y or N)?");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("Y")) {
            try {
                PrintWriter writer = new PrintWriter(new File("C:\\Eclipse-JRE\\Workspace\\Mod8port\\Autos.txt"));
                for (String info : auto.listVehicle()) {
                    writer.println(info);
                }
                writer.close();
                System.out.println("Information printed to file successfully");
            } catch (FileNotFoundException e) {
                System.out.println("Failed to print to file: " + e.getMessage());
            }
        } else {
            System.out.println("A file will not be printed");
        }

        scanner.close();
    }

    public static void printArray(String[] array) {
        for (String element : array) {
            System.out.println(element);
        }
    }
}

