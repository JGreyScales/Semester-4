package com.designtechniques.part1.step02_basics;

/**
 * Step 02: Basic Java concepts.
 * Topics: static typing, primitive types, default values, and simple expressions.
 */
public final class BasicsDemo {
    private BasicsDemo() {}

    public static void run() {
        int x = 5; // must be declared before use (static typing)
        double y = 2.5;
        double sum = x + y;
        System.out.println("x=" + x + ", y=" + y + ", sum=" + sum);

        PrimitiveDefaults defaults = new PrimitiveDefaults();
        System.out.println("Field defaults: " + defaults.snapshot());

        // Uncommenting below shows the compile-time error: local variables must be initialized.
        // int local;
        // System.out.println(local);

        System.out.println("Exercise hint: try running the tests after you implement Exercises.");
    }
}
