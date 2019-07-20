package chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * Pet
 */
public class Pet {
    String name;
    String animal;
    String breed;
    String color;
    double price;
    static List<Pet> pets = new ArrayList<>();

    public Pet(String name, String animal, String breed, String color, double price) {
        this.name = name;
        this.animal = animal;
        this.breed = breed;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ":" + " a " + color + " " + breed + " " + animal + " for $" + price;
    }

    @Override
    public boolean equals(Object obj) {
        Pet p = (Pet)obj;
        return animal.equals(p.animal) && breed.equals(p.breed);
    }
}
