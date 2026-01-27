package p11_generics;

import support.config.Config;

public class Main {
    public static void main(String[] args) {
        int boxValue = Config.getInt("demo.generic.boxValue", 42);

        Box<Integer> intBox = new Box<>(boxValue);
        Box<String> strBox = new Box<>("42");

        System.out.println(intBox);
        System.out.println(strBox);

        // TODO: EXERCISE 2
        // Create a Box<Double> and print it.
    }
}

