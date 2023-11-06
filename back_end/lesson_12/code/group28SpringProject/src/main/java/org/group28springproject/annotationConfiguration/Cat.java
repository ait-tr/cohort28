package org.group28springproject.annotationConfiguration;

import org.springframework.stereotype.Component;

@Component
public class Cat {

    private String name = "Barsik";

    public Cat() {
        System.out.println("Cat constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
