package com.az.dev.genericsandcollectionspart2;

import java.util.List;

/**
 * Created by aziarkash on 19-5-2016.
 */
public class Rental {

    private List rentalPool;

    private int maxNum;

    public Rental(int maxNum, List rentalPool) {
        this.maxNum = maxNum;
        this.rentalPool = rentalPool;
    }

    public Object getRental() {
        // blocks until there is something available
        return rentalPool.get(0);
    }

    public void returnRental(Object o) {
        rentalPool.add(o);
    }
}
