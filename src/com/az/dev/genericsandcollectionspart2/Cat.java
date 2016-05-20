package com.az.dev.genericsandcollectionspart2;

/**
 * Created by aziarkash on 19-5-2016.
 */
public class Cat extends Animal {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void checkup() {
        System.out.println("Cat checkup\t\t:\t" + name);
    }

    @Override
    public String toString() {
        return name;
    }
}
