package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.util.Objects;


public class Item implements Comparable<Item>{
    private int id;
    private LocalDateTime created = LocalDateTime.now();

    public LocalDateTime getCreated() {
        return created;
    }

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
    public Item(String name){
        this.name = name;
    }
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public int compareTo(Item item) {
        return Integer.compare(id, item.getId());
    }
}