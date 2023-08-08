package ait.pomegranate.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box implements Iterable<Pomegranate>{
    String name;
    List<Pomegranate> granates;

    public Box(String name) {
        this.name = name;
        granates = new ArrayList<>();
    }

    public Box(String name, List<Pomegranate> granates) {
        this.name = name;
        this.granates = granates;
    }

    public String getName() {
        return name;
    }

    public void setGranates(List<Pomegranate> granates) {
        this.granates = granates;
    }

    public boolean addGranate(Pomegranate granate) {
        return granates.add(granate);
    }

    public double weight() {
        return granates.stream()
                .map(g -> g.weight())
                .reduce(0.0, (a,b) -> a + b);
    }

    public int quantity() {
        return granates.size();
    }

    public int countSeeds() {
        return granates.stream()
                .map(g -> g.quantity())
                .reduce(0, (a,b) -> a + b);
    }

    @Override
    public Iterator<Pomegranate> iterator() {
        return granates.iterator();
    }

    @Override
    public String toString() {
        return "Box [name=" + name + ", seeds= " + countSeeds() + "]";
    }
}
