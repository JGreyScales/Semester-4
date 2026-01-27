package p10_wrappers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Collections work with objects, so primitives are boxed into wrapper types.
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);  // autoboxing: int -> Integer
        numbers.add(20);

        int sum = 0;
        for (Integer n : numbers) { // unboxing: Integer -> int
            sum += n;
        }
        System.out.println("Sum = " + sum);

        // TODO: EXERCISE 1
        // Parse an integer from a String using Integer.parseInt and handle invalid input.

        // TODO: EXERCISE 2
        // Demonstrate the difference between == and equals() for wrapper objects.
    }
}

