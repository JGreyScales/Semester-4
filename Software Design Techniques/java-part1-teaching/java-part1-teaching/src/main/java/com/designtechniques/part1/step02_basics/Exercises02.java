package com.designtechniques.part1.step02_basics;

/**
 * Student exercises for Step 02.
 *
 * Task A: Implement bmi(weightKg, heightCm) returning a double BMI value.
 * Task B: Implement isAdult(age) returning true if age >= 18.
 * Task C: Implement safeDivide(a, b): if b==0 throw IllegalArgumentException.
 */
public final class Exercises02 {
    private Exercises02() {}

    public static double bmi(double weightKg, double heightCm) {
        double heightM = heightCm / 100;
        double BMI = weightKg / (heightM * heightM);
        return BMI;
    }

    public static boolean isAdult(int age) {
        return age >= 18;
    }

    public static double safeDivide(double a, double b) {
        if (b == 0){
            throw new IllegalArgumentException("Divide by zero error");
        }
        return (a / b);
    }
}
