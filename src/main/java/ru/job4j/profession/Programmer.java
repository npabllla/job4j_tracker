package ru.job4j.profession;

public class Programmer extends Engineer{
    private String seniority;

    public Programmer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void coding(Object task) {
    }

    public void debugging(Object code){
    }
}
