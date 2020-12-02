package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int matches = 11;
        while (matches > 0) {
            /*
            System.out.println("Ход игрока №1, вы можете взять от 1 до 3 спичек");
                int temp = Integer.parseInt(in.nextLine());
                if(temp <= 3 && temp >= 1) {
                    matches -= temp;
                } else {
                    System.out.println("Некорректный ввод, ход переходит к игроку №2");
                }
            System.out.println("Оставшиеся спички: " + matches);
            System.out.println("Ход игрока №2, вы можете взять от 1 до 3 спичек");
            int temp1 = Integer.parseInt(in.nextLine());
            if(temp1 <= 3 && temp1 >= 1) {
                matches -= temp1;
            } else {
                System.out.println("Некорректный ввод, ход переходит к игроку №1");
            }
            System.out.println("Оставшиеся спички: " + matches);

             */
            System.out.println("Ход игрока №1");
            int temp = Integer.parseInt(in.nextLine());
            while (temp < 1 || temp > 3){
                temp = Integer.parseInt(in.nextLine());
            }
            matches -= temp;
            System.out.println("Осталось: " + matches);
            if(matches >= 1 && matches <= 3){
                System.out.println("Победил игрок №2, игра окончена");
                break;
            }
            System.out.println("Ход игрока №2");
            int temp1 = Integer.parseInt(in.nextLine());
            while (temp1 < 1 || temp1 > 4){
                temp1 = Integer.parseInt(in.nextLine());
            }
            matches -= temp1;
            System.out.println("Осталось: " + matches);
            if(matches >= 1 && matches <= 3) {
                System.out.println("Победил игрок №1, игра окончена");
                break;
            }
        }
    }
}
