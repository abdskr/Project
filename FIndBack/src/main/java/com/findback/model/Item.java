package com.findback.model;

public class Item {

    private int id;
    private String name;
    private String category;
    private String location;
    private String date;
    private String description;

    public Item(int id, String name, String category,
                String location, String date, String description) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.location = location;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}