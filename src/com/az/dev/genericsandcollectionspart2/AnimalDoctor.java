package com.az.dev.genericsandcollectionspart2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aziarkash on 19-5-2016.
 */
public class AnimalDoctor {

    public void checkAnimal(Animal animal) {
        animal.checkup();
    }

    public void checkAnimals(Animal[] animals) {
        for (Animal a : animals) {
            a.checkup();
        }
    }

    public void addAnimal(List<? super Dog> list) {
        list.add(new Dog("Jack"));
    }
}
