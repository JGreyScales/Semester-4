package p01_hello_packages;

import support.config.Config;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java (Packages demo)");

        int side = Config.getInt("demo.square.side", 4);
        int second_side = Config.getInt("demo.square.side_two", 6);
        Square square = new Square(side);
        Square square2 = new Square(second_side);
        square.display();
        square2.display();
    }
}

