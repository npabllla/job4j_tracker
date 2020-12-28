package ru.job4j.stream;

public class HumanBuild {
    public static void main(String[] args) {
        Human human = new Human.Builder()
                .buildFullName("Ivanov Ivan Ivanovich")
                .buildGender("Male")
                .buildAge(15)
                .buildEducation("Undergraduate degree")
                .buildChildren("No")
                .buildHeight(176.6)
                .buildWeight(78.6)
                .build();
        System.out.println(human);
    }
}
