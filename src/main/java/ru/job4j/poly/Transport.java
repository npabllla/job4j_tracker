package ru.job4j.poly;

public interface Transport {
    void ride();

    void passengers(int amount);

    int fillUp(int quantity);
}
