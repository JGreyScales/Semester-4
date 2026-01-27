package com.designtechniques.part1;

import com.designtechniques.part1.step03_controlflow.Exercises;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Enable when assigning Step03 exercises")
public class Step03ControlFlowTest {

    @Test
    void fizzBuzz_cases() {
        assertEquals("1", Exercises.fizzBuzz(1));
        assertEquals("Fizz", Exercises.fizzBuzz(3));
        assertEquals("Buzz", Exercises.fizzBuzz(5));
        assertEquals("FizzBuzz", Exercises.fizzBuzz(15));
    }

    @Test
    void letterGrade_bounds() {
        assertEquals('A', Exercises.letterGrade(90));
        assertEquals('B', Exercises.letterGrade(89));
        assertEquals('F', Exercises.letterGrade(0));
        assertThrows(IllegalArgumentException.class, () -> Exercises.letterGrade(-1));
        assertThrows(IllegalArgumentException.class, () -> Exercises.letterGrade(101));
    }
}
