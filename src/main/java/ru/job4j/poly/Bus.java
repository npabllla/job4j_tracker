package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void ride() {
        System.out.println("Ridding");
    }

    @Override
    public void passengers(int amount) {
        System.out.println("Amount of passengers: " + amount);
    }

    @Override
    public int fillUp(int quantity) {
        int cost = quantity * 45;
        return cost;
    }
}
