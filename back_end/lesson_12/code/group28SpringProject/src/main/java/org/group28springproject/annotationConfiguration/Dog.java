
package org.group28springproject.annotationConfiguration;

import org.springframework.stereotype.Component;

@Component
public class Dog {

    private String name = "Palkan";

    public Dog() {
        System.out.println("Dog constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
