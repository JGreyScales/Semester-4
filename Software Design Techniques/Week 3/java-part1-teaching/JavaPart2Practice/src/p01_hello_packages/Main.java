package p01_hello_packages;

import support.config.Config;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java (Packages demo)");

        int side = Config.getInt("demo.square.side", 3);
        Square square = new Square(side);
        square.display();

        // TODO: EXERCISE 2
        // Create a second Square with a different side length and display it.
    }
}

