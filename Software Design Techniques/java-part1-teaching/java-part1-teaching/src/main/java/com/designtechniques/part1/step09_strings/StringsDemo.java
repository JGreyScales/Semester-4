package com.designtechniques.part1.step09_strings;

/**
 * Step 09: Java String + String constant pool.
 * Topics: literals vs new String(...), == vs equals, and intern().
 */
public final class StringsDemo {
    private StringsDemo() {}

    public static void run() {
        String s1 = "Java";            // literal -> pooled
        String s2 = "Java";            // same pooled instance
        String s3 = new String("Java"); // new object on the heap

        System.out.println("s1 == s2 ? " + (s1 == s2));
        System.out.println("s1 == s3 ? " + (s1 == s3));
        System.out.println("s1.equals(s3) ? " + s1.equals(s3));

        String s4 = s3.intern();
        System.out.println("s1 == s4 (interned) ? " + (s1 == s4));
    }
}
