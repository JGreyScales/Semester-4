package com.designtechniques.part1;

import com.designtechniques.part1.step02_basics.Exercises;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Enable when assigning Step02 exercises")
public class Step02BasicsTest {

    @Test
    void parseTrimmedInt_trimsAndParses() {
        assertEquals(42, Exercises.parseTrimmedInt(" 42 "));
    }

    @Test
    void bmi_basic() {
        double bmi = Exercises.bmi(80.0, 1.80);
        assertTrue(bmi > 24.6 && bmi < 24.8);
    }
}
