package com.designtechniques.part1.step06_inheritance;

public class Student extends Person {
    private int id;

    public Student() {
        super();
    }

    public Student(int id, String name, int age) {
        super(name, age);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void study() {
        System.out.println(name + " studies and writes assignments (id=" + id + ").");
    }
}
