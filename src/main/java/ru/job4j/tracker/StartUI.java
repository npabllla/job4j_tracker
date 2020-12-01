package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All items ===");
                System.out.println(Arrays.toString(tracker.findAll()));
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                Item item = new Item(id, name);
                tracker.replace(id, item);
                if(tracker.replace(id, item)){
                    System.out.println("Replace completed successful");
                } else {
                    System.out.println("Replace wasn't complete - item wasn't found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("Enter id of item: ");
                int id = Integer.parseInt(scanner.nextLine());
                tracker.delete(id);
                if(tracker.delete(id)){
                    System.out.println("Deleting completed successful");
                } else {
                    System.out.println("Deleting wasn't complete - item wasn't found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                System.out.print("Enter id of item: ");
                int id = Integer.parseInt(scanner.nextLine());
                if(tracker.findById(id) != null) {
                    System.out.println(tracker.findById(id));
                } else {
                    System.out.println("Item not found - id is incorrect");
                }
            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
