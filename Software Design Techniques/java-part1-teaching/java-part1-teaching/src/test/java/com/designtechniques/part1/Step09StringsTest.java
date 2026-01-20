package com.designtechniques.part1;

import com.designtechniques.part1.step09_strings.Exercises;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Enable when assigning Step09 exercises")
public class Step09StringsTest {

    @Test
    void safeEquals_handlesNulls() {
        assertTrue(Exercises.safeEquals(null, null));
        assertFalse(Exercises.safeEquals(null, "x"));
        assertFalse(Exercises.safeEquals("x", null));
        assertTrue(Exercises.safeEquals("x", "x"));
        assertFalse(Exercises.safeEquals("x", "y"));
    }
}
