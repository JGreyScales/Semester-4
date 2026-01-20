package com.designtechniques.part1;

import com.designtechniques.part1.step02_basics.ParseAndMathExercises;
import com.designtechniques.part1.step03_controlflow.ControlFlowExercises;
import com.designtechniques.part1.step04_classes_objects.Person;
import com.designtechniques.part1.step04_classes_objects.PersonExercises;
import com.designtechniques.part1.step09_strings.StringExercises;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Enable these tests when you turn a step into an assignment.
 * Remove @Disabled (or comment it out) to activate.
 */
@Disabled("Enable per-assignment")
public class ExercisesTest {

    @Test
    void step02_safeParseInt() {
        assertEquals(42, ParseAndMathExercises.safeParseInt("42"));
        assertNull(ParseAndMathExercises.safeParseInt("oops"));
        assertNull(ParseAndMathExercises.safeParseInt(null));
    }

    @Test
    void step02_bmi() {
        assertEquals(25.0, ParseAndMathExercises.bmi(100.0, 2.0), 1e-9);
        assertTrue(Double.isNaN(ParseAndMathExercises.bmi(70.0, 0.0)));
    }

    @Test
    void step03_fizzBuzz() {
        assertEquals("1", ControlFlowExercises.fizzBuzz(1));
        assertEquals("Fizz", ControlFlowExercises.fizzBuzz(3));
        assertEquals("Buzz", ControlFlowExercises.fizzBuzz(5));
        assertEquals("FizzBuzz", ControlFlowExercises.fizzBuzz(15));
    }

    @Test
    void step03_countEvens() {
        assertEquals(3, ControlFlowExercises.countEvensInclusive(1, 6)); // 2,4,6
        assertEquals(3, ControlFlowExercises.countEvensInclusive(6, 1)); // swapped
    }

    @Test
    void step04_formatPerson() {
        Person p = new Person("Mona", 21);
        assertEquals("Person{name='Mona', age=21}", PersonExercises.formatPerson(p));
    }

    @Test
    void step09_intern() {
        String lit = "Java";
        String heap = new String("Java");
        assertTrue(StringExercises.isSameReferenceAfterIntern(heap, lit));
    }

    @Test
    void step09_countOccurrences() {
        assertEquals(2, StringExercises.countOccurrences("aaaa", "aa"));
        assertEquals(0, StringExercises.countOccurrences("aaaa", "b"));
        assertEquals(0, StringExercises.countOccurrences("", "aa"));
    }
}
