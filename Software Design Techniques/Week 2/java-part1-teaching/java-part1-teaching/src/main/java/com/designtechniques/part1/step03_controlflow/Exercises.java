package com.designtechniques.part1.step03_controlflow;

/**
 * Step 03 exercises.
 */
public final class Exercises {
    private Exercises() {}

    /**
     * Return "Fizz" if n divisible by 3, "Buzz" if divisible by 5,
     * "FizzBuzz" if divisible by both, otherwise the number as a String.
     */
    public static String fizzBuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0){
            return "FizzBuzz";
        } else if (n % 5 == 0){
            return "Buzz";
        } else if (n % 3 == 0){
            return "Fizz";
        } else {
            return Integer.toString(n);
        }
    }

    /**
     * Categorize a mark into a letter grade.
     * Use inclusive lower bounds: A:90-100, B:80-89, C:70-79, D:60-69, F:0-59.
     */
    public static char letterGrade(int percent) {
        if (percent > 100 || percent < 0){
            throw new IllegalArgumentException("Value is not a percent from 0-100");
        }

        if (percent >= 90){
            return 'A';
        } else if (percent >= 80){
            return 'B';
        } else if (percent >= 70){
            return 'C';
        } else if (percent >= 60){
            return 'D';
        } else {
            return 'F';
        }
    }
}
