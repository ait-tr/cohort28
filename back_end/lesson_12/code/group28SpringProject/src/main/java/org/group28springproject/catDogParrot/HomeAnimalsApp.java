package org.group28springproject.catDogParrot;

public class HomeAnimalsApp {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik");
        Dog dog = new Dog("Palkan");
        Parrot parrot = new Parrot("Kesha");

        AnimalService animalService = new AnimalService();

        animalService.eatForCat(cat);

    }
}
