package org.group28springproject.javaConfig;

public class Dog {
    private String name = "Palkan";

    public Dog() {
        System.out.println("Dog default constructor");
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
