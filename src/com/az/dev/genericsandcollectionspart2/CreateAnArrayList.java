package com.az.dev.genericsandcollectionspart2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aziarkash on 20-5-2016.
 */
public class CreateAnArrayList {

    private String name;

    // public <T> CreateAnArrayList(T t){
        // Legal
    // }

    public <T extends Animal> void makeArrayList(T t) {
        name = t.toString();
        List<T> list = new ArrayList<>();
        list.add(t);
    }

    @Override
    public String toString() {
        return name;
    }
}
