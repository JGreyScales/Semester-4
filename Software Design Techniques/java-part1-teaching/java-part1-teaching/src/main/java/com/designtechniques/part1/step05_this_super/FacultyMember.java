package com.designtechniques.part1.step05_this_super;

/**
 * Demonstrates using super(...) to initialize the base part of an object.
 */
public class FacultyMember extends Employee {
    private final String department;

    public FacultyMember(String employeeId, String department) {
        super(employeeId);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
