package view;

import controller.Controller;
import model.Spieler;
import model.Vereine;

import java.util.List;
import java.util.Scanner;

/**
 * Console-based UI for managing the sports store.
 */
public class View {

    private final Controller controller = new Controller();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Main menu.
     */
    public void start() {
        while (true) {
            System.out.println("\n----- EURO 2024 -----");
            System.out.println("1. Add Spieler");
            System.out.println("2. Update Spieler");
            System.out.println("3. Delete Spieler");
            System.out.println("4. Show All Spielers");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addSpieler();
                case 2 -> updateSpieler();
                case 3 -> deleteSpieler();
                case 4 -> showAllSpielers();

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addSpieler() {
        System.out.println("Spieler ID: ");
        int productID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Spieler Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Position: ");
        String position = scanner.nextLine();
        System.out.println("Marktwert: ");
        int marktwert = scanner.nextInt();
        scanner.nextLine();

        controller.addSpieler(new Spieler(productID,name, age, position, marktwert));
        System.out.println("Product added successfully!");
    }

    private void updateSpieler() {
        System.out.println("Product ID: ");
        int spielerID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New Name: ");
        String newName = scanner.nextLine();
        System.out.print("New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New Position: ");
        String position = scanner.nextLine();
        System.out.println("New Marktwert: ");
        int marktwert = scanner.nextInt();
        scanner.nextLine();

        controller.updateSpieler(spielerID, newName, age, position, marktwert);
    }

    private void deleteSpieler() {
        System.out.print("Enter the ID of the spieler to delete: ");
        int spielerID = scanner.nextInt();
        scanner.nextLine();
        controller.deleteSpieler(spielerID);
        System.out.println("Product deleted successfully!");
    }

    private void showAllSpielers() {
        if (controller.getSpielers().isEmpty()) {
            System.out.println("No spielers found.");
            return;
        }

        controller.getSpielers().forEach(System.out::println);
    }








}


