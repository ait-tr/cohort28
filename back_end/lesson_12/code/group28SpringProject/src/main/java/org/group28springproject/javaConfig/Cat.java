package org.group28springproject.javaConfig;

public class Cat {
    private String name = "Barsik";

    public Cat() {
        System.out.println("Cat default constructor");
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
