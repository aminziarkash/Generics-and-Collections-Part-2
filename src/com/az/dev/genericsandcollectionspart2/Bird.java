package com.az.dev.genericsandcollectionspart2;

/**
 * Created by aziarkash on 19-5-2016.
 */
public class Bird extends Animal {

    private String name;

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public void checkup() {
        System.out.println("Bird checkup\t:\t" + name);
    }

    @Override
    public String toString() {
        return name;
    }
}
