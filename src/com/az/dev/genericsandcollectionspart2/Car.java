package com.az.dev.genericsandcollectionspart2;

/**
 * Created by aziarkash on 19-5-2016.
 */
public class Car {

    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return brand;
    }
}
