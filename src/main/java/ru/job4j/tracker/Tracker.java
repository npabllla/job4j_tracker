package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findByName(String key){
        Item[] temps = new Item[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if(items[i].getName().equals(key)){
                temps[i] = items[i];
                counter++;
            }
        }
        return Arrays.copyOf(temps,counter);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items,size);
    }

    public boolean replace(int id, Item item) {
        boolean res = false;
        int index = indexOf(id);
        if (index < 0){
            System.out.println("Incorrect id");
            return false;
        } else {
                if (items[index].getId() == index + 1) {
                    items[index].setName(item.getName());
                    items[index].setId(index + 1);
                    res = true;
                }
            }
        return res;
    }

    public boolean delete(int id) {
        boolean res = false;
        int index = indexOf(id);
        if (index < 0){
            System.out.println("Incorrect id");
            return false;
        } else {
        for (int i = 0; i < size; i++) {
            if(items[i].getId() == index){
                System.arraycopy(items, index + 1, items, index, size - index);
                res = true;
            }
        }
        items[size - 1] = null;
        size--;
        }
        return res;
    }
}