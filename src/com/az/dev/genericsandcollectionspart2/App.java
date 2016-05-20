package com.az.dev.genericsandcollectionspart2;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by aziarkash on 18-5-2016.
 */
public class App {

    private String objectiveString;

    public static void main(String[] args) {

        App app = new App();

        app.navigatingTreeSetsAndTreeMaps();

        app.backedCollections();

        app.priorityQueue();

        app.theLegacyWayToDoCollections();

        app.mixingGenericsAndNonGenericCollections();

        app.polymorphismAndGenerics();

        app.myCustomGenericsClass();

        app.usingGenericWildcard();

        app.creatingGenericMethods();
    }

    private void creatingGenericMethods() {
        objectiveString = "Creating Generic Methods";
        System.out.println("\033[1m" + objectiveString + "\033[0m");
        addSub(objectiveString);

        CreateAnArrayList myArrayList = new CreateAnArrayList();
        myArrayList.makeArrayList(new Cat("Whiskas"));
        myArrayList.makeArrayList(new Dog("Charlie"));
        // myArrayList.makeArrayList(new Car("Tesla")); // Cannot add this type here since its not a subclass of Animal
        System.out.println(myArrayList);
        addSeparator();
    }

    private void usingGenericWildcard() {
        objectiveString = "Using Generic Wildcard <?>, <? extends Object> and <? super Object>";
        System.out.println("\033[1m" + objectiveString + "\033[0m");
        addSub(objectiveString);

        List<?> lisOfAnything = new ArrayList<Dog>();
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog("Rex"));
        dogList.add(new Dog("Jack"));
        lisOfAnything = dogList;
        System.out.println("Dog list (List<?> = List<Dog>)\t\t\t\t\t:\t" + lisOfAnything);

        List<? extends Animal> animalList = new ArrayList<>();
        List<Dog> dogList1 = new ArrayList<>();
        dogList1.add(new Dog(""));
        animalList = dogList1;


        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Sheeba"));
        catList.add(new Cat("Whiskas"));
        animalList = catList;
        System.out.println("Cat list (List<? extends Animal> = List<Cat>)\t:\t" + animalList);

        List<? super Animal> superAnimalList = new ArrayList<>();
        superAnimalList.add(new Dog("Dog"));
        superAnimalList.add(new Cat("Cat"));
        superAnimalList.add(new Bird("Bird"));
        System.out.println("Animal subclasses (List<? super Animal>)\t\t:\t" + superAnimalList);

        addSeparator();
    }

    private void addAnimal(List<? extends Animal> list) {
        ArrayList<Dog> dogs = new ArrayList<>();
    }

    private void myCustomGenericsClass() {
        objectiveString = "Making Your Own Generics Class";
        System.out.println("\033[1m" + objectiveString + "\033[0m");
        addSub(objectiveString);

        Car c1 = new Car("Tesla");
        Car c2 = new Car("Mercedes");
        Car c3 = new Car("BMW");
        Car c4 = new Car("Ferrari");
        List<Car> carList = new ArrayList<>();
        carList.add(c1);
        carList.add(c2);
        carList.add(c3);
        carList.add(c4);

        RentalGeneric<Car> carRental = new RentalGeneric<>(2, carList);
        Car carToRent = carRental.getRental(); // get idx0
        carRental.returnRental(carToRent);
        // carList.add(new Cat("Fluffy"));

        System.out.println("Rental car list\t:\t" + carList);
        System.out.println("Car to rent\t\t:\t" + carToRent);
        System.out.println(carRental);

        addSeparator();
    }

    private void polymorphismAndGenerics() {
        objectiveString = "Polymorphism And Generics";
        System.out.println("\033[1m" + objectiveString + "\033[0m");
        addSub(objectiveString);

        Dog[] dogs = {new Dog("Rex"), new Dog("Beethoven"), new Dog("Rocky")};
        Cat[] cats = {new Cat("Whiskas"), new Cat("Sheeba")};
        Bird[] birds = {new Bird("Smokey")};

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Dog("Dog"));
        animalList.add(new Cat("Cat"));
        animalList.add(new Bird("Bird"));
        System.out.println(animalList);

        AnimalDoctor doctor = new AnimalDoctor();
        doctor.checkAnimals(dogs);
        doctor.checkAnimals(cats);
        doctor.checkAnimals(birds);

        addSeparator();
    }

    private void mixingGenericsAndNonGenericCollections() {
        objectiveString = "Mixing Generics and Non-generic Collections";
        System.out.println("\033[1m" + objectiveString + "\033[0m");
        addSub(objectiveString);

        List list = new ArrayList<>();
        list.add(123);
        list.add(2);
        list.add("234");
        list.add(new Ferry());
        System.out.println("Non-generic list content\t\t\t:\t" + list);
        int x = (Integer) list.get(0);
        System.out.println("Get idx0 from this list (integer)\t:\t" + x);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(321);
        integerList.add(888);
        integerList.add(777);
        integerList.add(420);
        System.out.println("\nGeneric (integer) list content\t\t:\t" + integerList);
        int y = integerList.get(3);
        System.out.println("Get idx3 from this list (no casting)\t:\t" + y);

        NonGenericClass nonGenericClass = new NonGenericClass();
        nonGenericClass.insert(integerList); // inserting string to an integer list
        System.out.println("\nInserted a string value to this list using a non generic class...");
        System.out.println("Integers list\t:\t" + integerList);

        System.out.println();
        try {
            for (Integer integer : integerList) {
                System.out.println("Integer found\t:\t" + integer);
            }
        } catch (ClassCastException e) {
            System.out.println("\n[WARNING] Found a non-integer value!!");
        }

        addSeparator();
    }

    private void theLegacyWayToDoCollections() {
        objectiveString = "The Legacy Way To Do Collections";
        System.out.println("\033[1m" + objectiveString + "\033[0m");
        addSub(objectiveString);

        // Pre Java 5 (Non Generic)
        List myList = new ArrayList<>();
        myList.add("Amin Ziarkash"); // add string
        myList.add(new Ferry()); // add Ferry object
        myList.add(3000); // add an int
        System.out.println("Non generic list\t\t:\t" + myList);
        String s = (String) myList.get(0);
        System.out.println("Get string at idx0\t\t:\t" + s);
        // String s1 = (String) myList.get(1);
        // System.out.println("Get string at idx1\t:\t" + s1); // trying to get a string but the 2nd idx of the list is an object

        // Post Java 5 (Generic)
        List<String> myListStrings = new ArrayList<>();
        myListStrings.add("Varun Aggarwal");
        myListStrings.add("Xiaochen Zhang");
        // myListStrings.add(new Ferry()); // Not allowed because of 'generics' restriction to Strings only
        // myListStrings.add(123);
        System.out.println("\nGeneric list of Strings\t:\t" + myListStrings);
        String newString = myListStrings.get(1); // No casting is needed because it is already a string list
        System.out.println("Get string at idx1\t\t:\t" + newString);
        addStringToList(myListStrings);
        System.out.println("\nList after adding value using 'generics' method argument" + "\n" + myListStrings);

        addSeparator();
    }

    private void addStringToList(List<String> stringList) {
        stringList.add("Quasar");
    }

    private void priorityQueue() {
        objectiveString = "PriorityQueue class";
        System.out.println("\033[1m" + objectiveString + "\033[0m");
        addSub(objectiveString);

        MyPriorityQueue priorityQueue = new MyPriorityQueue();
        priorityQueue.priorityQueueExample();

        addSeparator();
    }

    private void backedCollections() {
        objectiveString = "Backed Collections";
        System.out.println("\033[1m" + objectiveString + "\033[0m");
        addSub(objectiveString);

        TreeMap<String, String> map = new TreeMap<>();
        map.put("a", "ant");
        map.put("d", "dog");
        map.put("h", "horse");
        System.out.println("Map values\t\t:\t" + map);          // #1 show contents

        SortedMap<String, String> subMap;
        subMap = map.subMap("b", "g");                          // #2 create a backed collection
        System.out.println("SubMap b-g incl\t:\t" + subMap);
        map.put("b", "bat");                                    // #3 add to original
        subMap.put("f", "fish");                                // #4 add to copy
        map.put("r", "raccoon");                                // #5 add to original - out of range
        // subMap.put("p", "pig");                              // #6 add to copy - will throw Exception and say out of range because we specifically said (b-g)
        System.out.println("\nFinal map\t\t:\t" + map);         // #7 show final contents
        System.out.println("Final SubMap\t:\t" + subMap);

        addSeparator();
    }

    private void navigatingTreeSetsAndTreeMaps() {
        objectiveString = "Navigating TreeSets And TreeMaps";
        System.out.println("\033[1m" + objectiveString + "\033[0m");
        addSub(objectiveString);

        Ferry ferry = new Ferry();
        ferry.ferryDepartureTimesJava5();  // Java 5 way
        ferry.ferryDepartureTimesJava6(); // Java 6 way

        addSeparator();
    }

    private void addSub(String objectiveString) {
        for (int i = 0; i < objectiveString.length(); i++) {
            System.out.print("-");
        }
        System.out.println("\n");
    }

    private void addSeparator() {
        System.out.println("\n\033[1m**************************************************************************************************************\033[0m");
    }

}
