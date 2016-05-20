package com.az.dev.genericsandcollectionspart2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aziarkash on 19-5-2016.
 */
public class RentalGeneric<T> {

    private List rentalPool;

    private int maxNum;

    public RentalGeneric(int maxNum, List<T> rentalPool) {
        this.maxNum = maxNum;
        this.rentalPool = rentalPool;
    }

    public T getRental() {
        return (T)rentalPool.get(0);
    }

    public void returnRental(T returnedThing) {
        rentalPool.add(returnedThing);
    }

//    public <T> void makeArrayList(T t) { // take an object of an unknown type and use a "T" to represent the type
//        List<T> list = new ArrayList<T>(); // now we can create the list using "T"
//        list.add(t); // add to the list
//    }
}
