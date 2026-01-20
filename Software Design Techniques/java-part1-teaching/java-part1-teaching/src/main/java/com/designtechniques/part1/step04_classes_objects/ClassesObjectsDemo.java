package com.designtechniques.part1.step04_classes_objects;

/**
 * Step 04: Classes and objects.
 * Topics: class structure, encapsulation via private fields, getters/setters,
 * constructors, and object instantiation using new.
 */
public final class ClassesObjectsDemo {
    private ClassesObjectsDemo() {}

    public static void run() {
        Person p1 = new Person();
        p1.setName("Mike");
        p1.setAge(20);

        Person p2 = new Person("Arely", 22);

        System.out.println(p1);
        System.out.println(p2);

        p1.study();
        p2.study();
    }
}
