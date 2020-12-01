package ru.job4j.tracker;

import java.util.Arrays;


public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All items ===");
                System.out.println(Arrays.toString(tracker.findAll()));
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                int id = input.askInt("Enter id: ");
                String name = input.askStr("Enter new name: ");
                Item item = new Item(id, name);
                tracker.replace(id, item);
                if(tracker.replace(id, item)){
                    System.out.println("Replace completed successful");
                } else {
                    System.out.println("Replace wasn't complete - item wasn't found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                int id = input.askInt("Enter id of item: ");
                tracker.delete(id);
                if(tracker.delete(id)){
                    System.out.println("Deleting completed successful");
                } else {
                    System.out.println("Deleting wasn't complete - item wasn't found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                int id = input.askInt("Enter id of item: ");
                if(tracker.findById(id) != null) {
                    System.out.println(tracker.findById(id));
                } else {
                    System.out.println("Item not found - id is incorrect");
                }
            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                String name = input.askStr("Enter name: ");
                if(tracker.findByName(name).length > 0) {
                    System.out.println(Arrays.toString(tracker.findByName(name)));
                } else {
                    System.out.println("Items not found - name is incorrect");
                }
            } else if (select == 6) {
                System.out.println("=== Exit ===");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0.Add new item");
        System.out.println("1.Show all items");
        System.out.println("2.Edit item");
        System.out.println("3.Delete item");
        System.out.println("4.Find item by id");
        System.out.println("5.Find items by name");
        System.out.println("6.Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
