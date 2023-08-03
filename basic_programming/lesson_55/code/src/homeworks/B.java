package ait.entitycollection.dao;

import ait.entitycollection.interfaces.Entity;
import ait.entitycollection.interfaces.EntityCollection;

import java.util.Comparator;
import java.util.TreeSet;

public class B implements EntityCollection {

    Comparator<Entity> comp = (e1, e2) -> Integer.compare(e1.getValue(),e2.getValue());
    TreeSet<Entity> collection = new TreeSet<>(comp);

    @Override
    //O(log(n))
    public void add(Entity entity) {
        collection.add(entity);
    }

    @Override
    //O(log(n))
    public Entity removeMaxValue() {
        return collection.pollLast();
    }
}
