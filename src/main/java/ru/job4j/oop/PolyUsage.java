package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle plane = new Plane();
        Vehicle[] transport = new Vehicle[]{bus, train, plane};
        for (Vehicle arr:transport) {
            arr.move();
        }
    }
}
