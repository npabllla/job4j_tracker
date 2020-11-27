package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox play = new Jukebox();
        int firstSong = 1;
        int secondSong = 2;
        int thirdSong = 4;
        play.music(firstSong);
        play.music(secondSong);
        play.music(thirdSong);
    }
}
