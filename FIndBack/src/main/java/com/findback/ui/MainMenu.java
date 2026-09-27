package com.findback.ui;

import com.findback.model.Item;
import com.findback.service.ItemService;

import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private final ItemService itemService;

    public MainMenu() {
        itemService = new ItemService();
    }

    private void reportLostItem(Scanner scanner) {

        System.out.println();
        System.out.println("========== REPORT LOST ITEM ==========");

        System.out.print("Enter item title: ");
        String title = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        Item item = new Item(
                title,
                category,
                location,
                "LOST"
        );

        itemService.addItem(item);

        System.out.println();
        System.out.println("Lost item reported successfully! ✅");
        System.out.println("Generated ID: " + item.getId());
    }


    private void reportFoundItem(Scanner scanner) {

        System.out.println();
        System.out.println("========== REPORT FOUND ITEM ==========");

        System.out.print("Enter item title: ");
        String title = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        Item item = new Item(
                title,
                category,
                location,
                "FOUND"
        );

        itemService.addItem(item);

        System.out.println();
        System.out.println("Found item reported successfully! ✅");
        System.out.println("Generated ID: " + item.getId());
    }


    private void viewAllItems() {

        System.out.println();
        System.out.println("========== ALL ITEMS ==========");

        List<Item> items = itemService.getAllItems();

        if (items.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        for (Item item : items) {

            System.out.println("-------------------------------");
            System.out.println("ID: " + item.getId());
            System.out.println("Title: " + item.getTitle());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Location: " + item.getLocation());
            System.out.println("Status: " + item.getStatus());
            System.out.println("Date Reported: " + item.getDateReported());
        }

        System.out.println("-------------------------------");
    }


    private void searchItems(Scanner scanner) {

        System.out.println();
        System.out.println("========== SEARCH ITEMS ==========");

        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        List<Item> results = itemService.searchItems(keyword);

        if (results.isEmpty()) {
            System.out.println("No matching items found.");
            return;
        }

        System.out.println();
        System.out.println("Search Results:");

        for (Item item : results) {

            System.out.println("-------------------------------");
            System.out.println("ID: " + item.getId());
            System.out.println("Title: " + item.getTitle());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Location: " + item.getLocation());
            System.out.println("Status: " + item.getStatus());
            System.out.println("Date Reported: " + item.getDateReported());
        }

        System.out.println("-------------------------------");
    }


    public void show() {

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("           MAIN MENU");
            System.out.println("=================================");
            System.out.println("1. Report Lost Item");
            System.out.println("2. Report Found Item");
            System.out.println("3. Search Items");
            System.out.println("4. View All Items");
            System.out.println("5. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Report Lost Item selected.");
                    reportLostItem(scanner);
                    break;

                case 2:
                    System.out.println("Report Found Item selected.");
                    reportFoundItem(scanner);
                    break;

                case 3:
                    searchItems(scanner);
                    break;

                case 4:
                    viewAllItems();
                    break;

                case 5:
                    System.out.println("Thank you for using FindBack.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}