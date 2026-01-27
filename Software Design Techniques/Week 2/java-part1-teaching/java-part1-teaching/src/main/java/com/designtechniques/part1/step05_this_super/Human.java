package com.designtechniques.part1.step05_this_super;

public class Human {
    private final String name;

    public Human() {
        this("Unknown");
    }

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
