package com.designtechniques.part1.step07_object_class;

import java.util.Objects;

/**
 * A small class that treats name+age as identity to illustrate equals/hashCode/toString.
 */
public class ValuePerson {
    private final String name;
    private final int age;

    public ValuePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ValuePerson{name='" + name + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValuePerson that)) return false;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
