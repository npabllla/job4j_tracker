package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public String sound() {
        String voice = "may-may";
        return voice;
    }
    public void show() {
        System.out.println(this.name + " - " + this.food);
    }
    public void eat(String meat) {
        this.food = meat;
    }
    public void getNick(String nick){
        this.name = nick;
    }
    public static void main(String[] args) {
        System.out.println("There are gav's nick and food.");
        Cat gav = new Cat();
        gav.getNick("Good cat");
        gav.eat("Kotleta");
        gav.show();
        System.out.println("There are black's nick and food.");
        Cat black = new Cat();
        black.getNick("Sad cat");
        black.eat("Fish");
        black.show();
    }
}