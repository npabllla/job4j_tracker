package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int matches = 11;
        while (matches > 0) {
            System.out.println("Ход игрока №1");
            int inputFirst = Integer.valueOf(in.nextLine());
            while (inputFirst < 1 || inputFirst > 3){
                inputFirst = Integer.valueOf(in.nextLine());
            }
            matches -= inputFirst;
            System.out.println("Осталось: " + matches);
            if(matches >= 1 && matches <= 3){
                System.out.println("Победил игрок №2, игра окончена.");
                break;
            }
            System.out.println("Ход игрока №2");
            int inputSecond = Integer.valueOf(in.nextLine());
            while (inputSecond < 1 || inputSecond > 3){
                inputSecond = Integer.valueOf(in.nextLine());
            }
            matches -= inputSecond;
            System.out.println("Осталось: " + matches);
            if(matches >= 1 && matches <= 3) {
                System.out.println("Победил игрок №1, игра окончена.");
                break;
            }
        }
    }
}
