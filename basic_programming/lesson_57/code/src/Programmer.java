package ait.programmer.model;

import java.util.Arrays;

public class Programmer {
    String name;
    String[] technologies;

    public Programmer(String name, String... technologies) {
        this.name = name;
        this.technologies = technologies;
    }

    public String getName() {
        return name;
    }

    public String[] getTechnologies() {
        return technologies;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Programmer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", technologies=").append(Arrays.toString(technologies));
        sb.append('}');
        return sb.toString();
    }
}
