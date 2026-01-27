package p10_wrappers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Collections work with objects, so primitives are boxed into wrapper types.
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);  // autoboxing: int -> Integer
        numbers.add(20);

        Integer compareNumber = new Integer(10);
        int sum = 0;
        for (Integer n : numbers) { // unboxing: Integer -> int
            sum += n;
            System.out.println(Integer.parseInt(n.toString())); // reading int from a string

        }
        System.out.println("Sum = " + sum);


        // == is checking reference equality
        // equals is checking the actual value

        // according to my research values between -128 and 127 would be cached by the compiler and reference equal correctly
        // for example

        // Integer a = 10;
        // Integer b = 10;
        // System.out.println(a == b); would be true


        System.out.println("Using equality: " + (compareNumber == numbers.get(0)));
        System.out.println("Using equals(): " + (compareNumber.equals(numbers.get(0))));
    }
}

