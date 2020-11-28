package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load){
        this.load = load;
    }
    public void exchange(Battery another){
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
    Battery batteryFirst = new Battery(85);
    Battery batterySecond = new Battery(5);
    System.out.println("Initial state: first battery charge is "+ batteryFirst.load + ", second battery is - " + batterySecond.load);
    batteryFirst.exchange(batterySecond);
    System.out.println("Afterwards state: first battery charge is "+ batteryFirst.load + ", second battery is - " + batterySecond.load);
    }
}
