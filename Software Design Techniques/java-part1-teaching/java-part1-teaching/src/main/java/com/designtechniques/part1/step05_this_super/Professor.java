package com.designtechniques.part1.step05_this_super;

/**
 * Shows both this(...) constructor chaining and super(...).
 */
public class Professor extends Human {
    private final String department;

    public Professor() {
        this("Unknown", "Unknown"); // this(...) must be the first statement
    }

    public Professor(String name) {
        this(name, "Unknown");
    }

    public Professor(String name, String department) {
        super(name); // call superclass constructor
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Professor{name='" + getName() + "', department='" + department + "'}";
    }
}
