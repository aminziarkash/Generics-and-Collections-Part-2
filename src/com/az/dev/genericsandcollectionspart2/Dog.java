package com.az.dev.genericsandcollectionspart2;

/**
 * Created by aziarkash on 19-5-2016.
 */
public class Dog extends Animal {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void checkup() {
        System.out.println("Dog checkup\t\t:\t" + name);
    }

    @Override
    public String toString() {
        return name;
    }
}
