package p06_strings;

public class Main {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println("s1 == s2: " + (s1 == s2));       // same pool reference
        System.out.println("s1 == s3: " + (s1 == s3));       // different object
        System.out.println("s1.equals(s3): " + s1.equals(s3));

        // TODO: EXERCISE 1
        // Add a small method that counts vowels in a string and test it on at least 2 inputs.

        // TODO: EXERCISE 2
        // Demonstrate StringBuilder by building a CSV line from 3 fields.
    }
}

