package org.group28springproject.annotationConfiguration;

import org.springframework.stereotype.Component;

@Component("parrot-kesha")
public class Parrot {

    private String name = "Kesha";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
