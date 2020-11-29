package ru.job4j.pojo;

public class Book {
    private String name;
    private int amountList;

    public Book(String name, int amountList){
        this.name = name;
        this.amountList = amountList;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountList() {
        return amountList;
    }

    public void setAmountList(int amountList) {
        this.amountList = amountList;
    }
}
