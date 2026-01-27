package com.designtechniques.part1.step06_inheritance;

public class Person {
    protected String name;
    protected int age;

    public Person() {
        this("Unknown", 0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void study() {
        System.out.println(name + " studies in a generic way.");
    }
}
