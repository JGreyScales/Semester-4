package com.designtechniques.part1.step06_inheritance;

public class PersonBase {
    protected String name;
    protected int age;

    public PersonBase(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void study() {
        System.out.println(name + " is studying");
    }
}
