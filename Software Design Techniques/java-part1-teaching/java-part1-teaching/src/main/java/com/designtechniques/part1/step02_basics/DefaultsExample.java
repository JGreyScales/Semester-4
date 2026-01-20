package com.designtechniques.part1.step02_basics;

/**
 * Demonstrates default values for fields.
 */
public final class DefaultsExample {
    private int intField;          // default 0
    private double doubleField;    // default 0.0
    private boolean boolField;     // default false
    private String refField;       // default null

    @Override
    public String toString() {
        return "DefaultsExample{" +
                "intField=" + intField +
                ", doubleField=" + doubleField +
                ", boolField=" + boolField +
                ", refField=" + refField +
                '}';
    }
}
