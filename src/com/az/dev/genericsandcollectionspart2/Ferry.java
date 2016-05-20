package com.az.dev.genericsandcollectionspart2;

import java.util.TreeSet;

/**
 * Created by aziarkash on 18-5-2016.
 */
public class Ferry {

    void ferryDepartureTimesJava5() {
        System.out.println("Java 5 way");
        TreeSet<Integer> times = new TreeSet<>();
        setFerryTimes(times);
        TreeSet<Integer> subset = new TreeSet<>();
        subset = (TreeSet) times.headSet(1600);
        System.out.println("Last ferry before 4 pm is\t:\t" + subset.last());
        TreeSet<Integer> sub2 = new TreeSet<>();
        sub2 = (TreeSet) times.tailSet(2000);
        System.out.println("First ferry after 8pm is\t:\t" + sub2.first());
    }

    void ferryDepartureTimesJava6() {
        System.out.println("\nJava 6 way");
        TreeSet<Integer> times = new TreeSet<>();
        setFerryTimes(times);
        System.out.println("Last ferry before 4 pm is\t:\t" + times.lower(1600));
        System.out.println("First ferry after 8pm is\t:\t" + times.higher(2000));
    }

    private void setFerryTimes(TreeSet<Integer> times) {
        times.add(1205);
        times.add(1505);
        times.add(1545);
        times.add(1830);
        times.add(2010);
        times.add(2100);
    }
}
