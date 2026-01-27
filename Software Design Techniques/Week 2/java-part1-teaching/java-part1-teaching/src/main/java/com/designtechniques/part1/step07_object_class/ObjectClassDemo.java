package com.designtechniques.part1.step07_object_class;

/**
 * Step 07: The Object class in Java.
 * Topics: toString, equals, hashCode, and why overriding matters.
 */
public final class ObjectClassDemo {
    private ObjectClassDemo() {}

    static final class DefaultToString {
        private final int x;
        DefaultToString(int x) { this.x = x; }
    }

    public static void run() {
        DefaultToString a = new DefaultToString(1);
        System.out.println("Default toString: " + a);

        Book b1 = new Book("978-0", "Java");
        Book b2 = new Book("978-0", "Java (2nd printing)");

        System.out.println("Custom toString: " + b1);
        System.out.println("equals by isbn: " + b1.equals(b2));
        System.out.println("hashCode: " + b1.hashCode());
    }
}
