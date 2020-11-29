package ru.job4j.profession;

public class Surgeon extends Doctor{
    public Surgeon(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public String operation(Object patient){
        return "Result of operation is ...";
    }
}
