public class challenge2 {

    public static void main(String[] args) {
        // Test numbers 0 to 30 (31 tests)
        for (int i = 0; i <= 30; i++) {
            String expected = getExpected(i);
            String actual = fizzBuzz(i);
            if (expected.equals(actual)) {
                System.out.println("PASS: " + i + " -> " + actual);
            } else {
                System.out.println("FAIL: " + i + " -> Expected: " + expected + ", Got: " + actual);
            }
        }
    }

    // Helper function to get expected result for test
    public static String getExpected(int n) {
        if (n == 0) {return String.valueOf(n);}
        if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz";
        if (n % 3 == 0) return "Fizz";
        if (n % 5 == 0) return "Buzz";
        return String.valueOf(n);
    }


    // all above is AI generated to save time 

    public static String fizzBuzz(int n) {
        // prevent undefined behaviour
        if (n == 0) {return "0";}

        // we store the modulo operations to boolean
        // because boolean is faster to compare / check the value of
        // this is because worst case, we need to check these values twice each
        boolean divisibleBy3 = (n % 3 == 0);
        boolean divisibleBy5 = (n % 5 == 0);

    
        if (divisibleBy3 && divisibleBy5) {return "FizzBuzz";}
        // its more likely to be divisible by 3 first if not also 5
        // if this if case triggers, its only 3 checks instead of 4
        if (divisibleBy3) {return "Fizz";}
        if (divisibleBy5) {return "Buzz";}
        return String.valueOf(n);
    }
}
