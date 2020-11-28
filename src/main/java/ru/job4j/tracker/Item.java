package ru.job4j.tracker;

public class Item {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getId() {
        return id;
    }

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Item item = new Item();
        Item item1 = new Item(1);
        Item item2 = new Item(2, "Kirill");
    }
}