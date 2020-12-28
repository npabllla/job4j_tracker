package ru.job4j.stream;

public class Human {
    private String fullName;
    private String gender;
    private int age;
    private String education;
    private String children;
    private double height;
    private double weight;

    @Override
    public String toString() {
        return "Human{" +
                "fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", children='" + children + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    static class Builder{
        private String fullName;
        private String gender;
        private int age;
        private String education;
        private String children;
        private double height;
        private double weight;

        Builder buildFullName(String fullName){
            this.fullName = fullName;
            return this;
        }

        Builder buildGender(String gender){
            this.gender = gender;
            return this;
        }

        Builder buildAge(int age){
            this.age = age;
            return this;
        }

        Builder buildEducation(String education){
            this.education = education;
            return this;
        }

        Builder buildChildren(String children){
            this.children = children;
            return this;
        }

        Builder buildHeight(double height){
            this.height = height;
            return this;
        }

        Builder buildWeight(double weight){
            this.weight = weight;
            return this;
        }

        Human build(){
            Human human = new Human();
            human.fullName = fullName;
            human.gender = gender;
            human.age = age;
            human.education = education;
            human.children = children;
            human.height = height;
            human.weight = weight;
            return human;
        }
    }
}

