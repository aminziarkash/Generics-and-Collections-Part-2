package com.az.dev.genericsandcollectionspart2;

import java.util.List;

/**
 * Created by aziarkash on 19-5-2016.
 */
public class CarRental extends Rental {

    public CarRental(int maxNum, List<Car> rentalPool) {
        super(maxNum, rentalPool);
    }

    @Override
    public Car getRental() {
        return (Car)super.getRental();
    }

    public void returnRental(Car c) {
        super.returnRental(c);
    }

    @Override
    public void returnRental(Object o) {
        if (o instanceof Car) {
            super.returnRental(o);
        } else {
            System.out.println("Cannot add a non-car");
        }
    }
}
