package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Boblak Kirill");
        student.setDate("29.11.2020");
        student.setGroup("Group#3151");

        System.out.println(student.getFullName());
        System.out.println(student.getGroup());
        System.out.println(student.getDate());
    }
}
