package com.designtechniques.part1.step06_inheritance;

/**
 * Step 06: Inheritance.
 * Shows extends, superclass/subclass terminology, and method overriding.
 */
public final class InheritanceDemo {
    private InheritanceDemo() {}

    public static void run() {
        Person p = new Person("Person", 40);
        Student s = new Student(101, "Student", 20);

        p.study();
        s.study();

        // Polymorphism in action: a Student can be referenced as a Person.
        Person polymorphic = s;
        polymorphic.study();
    }
}
