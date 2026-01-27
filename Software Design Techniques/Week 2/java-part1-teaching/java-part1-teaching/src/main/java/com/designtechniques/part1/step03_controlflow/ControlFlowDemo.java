package com.designtechniques.part1.step03_controlflow;

/**
 * Step 03: Control flow statements.
 * Topics: if/else, switch, for, while, do-while.
 */
public final class ControlFlowDemo {
    private ControlFlowDemo() {}

    public static void run() {
        int x = 11;

        if (x > 10) {
            System.out.println("x > 10");
        } else {
            System.out.println("x <= 10");
        }

        switch (x) {
            case 10 -> System.out.println("ten");
            case 11 -> System.out.println("eleven");
            default -> System.out.println("something else");
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        int n = 0;
        while (n < 3) {
            System.out.println("while n=" + n);
            n++;
        }

        int m = 0;
        do {
            System.out.println("do-while m=" + m);
            m++;
        } while (m < 2);

        System.out.println("Exercise hint: implement Exercises.fizzBuzz and category.");
    }
}
