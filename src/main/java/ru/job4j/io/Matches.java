package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int matches = 11;
        int count = 1;
        int player;
        while (matches > 0) {
            player = count % 2 == 1 ? 1 : 2;
            System.out.println("Ход игрока №" + player);
            int temp = Integer.parseInt(in.nextLine());
            while (temp < 1 || temp > 3){
                temp = Integer.parseInt(in.nextLine());
            }
            matches -= temp;
            System.out.println("Осталось: " + matches);
            if(matches >= 1 && matches <= 3 && player == 1) {
                System.out.println("Победил игрок №2, игра окончена");
                break;
            } else if (matches >= 1 && matches <= 3) {
                System.out.println("Победил игрок №1, игра окончена");
                break;
            }
            count++;
        }
    }
}
