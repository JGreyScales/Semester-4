package com.designtechniques.part1.step04_classes_objects;

/**
 * Simple POJO to demonstrate fields, constructors, getters/setters, and methods.
 */
public class Person {
    private String name;
    private int age;

    // Default constructor (no-arg)
    public Person() {
        this("Unknown", 0);
    }

    // Constructor with parameters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void study() {
        System.out.println(name + " is studying.");
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
