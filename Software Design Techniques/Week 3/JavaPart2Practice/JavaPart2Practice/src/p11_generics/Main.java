package p11_generics;

import support.config.Config;

public class Main {
    public static void main(String[] args) {
        int boxValue = Config.getInt("demo.generic.boxValue", 42);

        Box<Integer> intBox = new Box<>(boxValue);
        Box<String> strBox = new Box<>("42");
        Box<Double> dblBox = new Box<>(42.00);

        System.out.println(intBox);
        System.out.println(strBox);
        System.out.println(dblBox);
    }
}

