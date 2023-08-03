package ait.entitycollection.dao;

import ait.entitycollection.interfaces.Entity;
import ait.entitycollection.interfaces.EntityCollection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class A implements EntityCollection {

    HashSet<Entity> collection = new HashSet<>();
    Comparator<Entity> comp = (e1, e2) -> Integer.compare(e1.getValue(),e2.getValue());

    @Override
    //O(1)
    public void add(Entity entity) {
        collection.add(entity);

    }

    @Override
    //O(n)
    public Entity removeMaxValue() {
        Entity max = Collections.max(collection, comp);
        collection.remove(max);
        return max;
    }
}
