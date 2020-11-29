package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        Book cleanCode = new Book("Clean code", 1010);
        Book someBook = new Book("Some book", 123);
        Book childBook = new Book("Child book", 15);
        Book difficultBook = new Book("Difficult book", 5385);
        books[0] = cleanCode;
        books[1] = someBook;
        books[2] = childBook;
        books[3] = difficultBook;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println("Name - " + bk.getName() + ", lists - " + bk.getAmountList());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Books after swap: ");
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println("Name - " + bk.getName() + ", lists - " + bk.getAmountList());
        }
        System.out.println("All 'Clean code' books: ");
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if (bk.getName().equals("Clean code")) {
                System.out.println("Name - " + bk.getName() + ", lists - " + bk.getAmountList());

            }
        }
    }
}
