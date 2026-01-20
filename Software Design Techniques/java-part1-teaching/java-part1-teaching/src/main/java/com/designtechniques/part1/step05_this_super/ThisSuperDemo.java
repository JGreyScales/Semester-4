package com.designtechniques.part1.step05_this_super;

/**
 * Step 05: Using this and super keywords.
 */
public final class ThisSuperDemo {
    private ThisSuperDemo() {}

    public static void run() {
        Professor p0 = new Professor();
        Professor p1 = new Professor("Mike");
        Professor p2 = new Professor("Akrem", "Software Design");

        System.out.println(p0);
        System.out.println(p1);
        System.out.println(p2);
    }
}
