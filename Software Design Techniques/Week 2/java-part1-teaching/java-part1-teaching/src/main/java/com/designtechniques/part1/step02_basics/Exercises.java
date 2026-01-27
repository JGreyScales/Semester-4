package com.designtechniques.part1.step02_basics;

/**
 * Step 02 exercises.
 *
 * Guidance for students:
 * Implement these methods without using external libraries.
 */
public final class Exercises {
    private Exercises() {}

    /**
     * Parse an int from a String that may have leading/trailing spaces.
     * Example: " 42 " -> 42
     */
    public static int parseTrimmedInt(String input) {
        int value = Integer.parseInt(input.trim());
        return value;
    }

    /**
     * Compute BMI = weightKg / (heightM^2).
     * Keep it as a double (no rounding).
     */
    public static double bmi(double weightKg, double heightM) {
        double BMI = weightKg / (heightM * heightM);
        return BMI;
    }
}
