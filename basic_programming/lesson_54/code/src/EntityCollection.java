package ait.entitycollection.interfaces;

public interface EntityCollection {
    void add(Entity entity);

    Entity removeMaxValue();
}
