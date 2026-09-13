package com.findback;

import com.findback.model.Item;
import com.findback.ui.MainMenu;

public class Main {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("         FIND BACK SYSTEM");
        System.out.println("   Smart Campus Lost & Found");
        System.out.println("=================================");

        Item item = new Item(
                1,
                "Black Wallet",
                "Wallet",
                "Cafeteria",
                "2026-09-12",
                "Black leather wallet"
        );

        System.out.println("Item created:");
        System.out.println("ID: " + item.getId());
        System.out.println("Name: " + item.getName());
        System.out.println("Category: " + item.getCategory());
        System.out.println("Location: " + item.getLocation());
        System.out.println("Date: " + item.getDate());
        System.out.println("Description: " + item.getDescription());

        MainMenu mainMenu = new MainMenu();
        mainMenu.show();
    }
}