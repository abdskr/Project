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

    System.out.print("Enter item ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter item name: ");
    String name = scanner.nextLine();

    System.out.print("Enter category: ");
    String category = scanner.nextLine();

    System.out.print("Enter location: ");
    String location = scanner.nextLine();

    System.out.print("Enter date: ");
    String date = scanner.nextLine();

    System.out.print("Enter description: ");
    String description = scanner.nextLine();

    Item item = new Item(
            id,
            name,
            category,
            location,
            date,
            description
    );

    itemService.addItem(item);

    System.out.println();
    System.out.println("Lost item reported successfully! ✅");
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
        System.out.println("Name: " + item.getName());
        System.out.println("Category: " + item.getCategory());
        System.out.println("Location: " + item.getLocation());
        System.out.println("Date: " + item.getDate());
        System.out.println("Description: " + item.getDescription());
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
        System.out.println("Name: " + item.getName());
        System.out.println("Category: " + item.getCategory());
        System.out.println("Location: " + item.getLocation());
        System.out.println("Date: " + item.getDate());
        System.out.println("Description: " + item.getDescription());
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

        switch (choice) {

            case 1:
                System.out.println("Report Lost Item selected.");
                reportLostItem(scanner);
                break;

            case 2:
                System.out.println("Report Found Item selected.");
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
}
}