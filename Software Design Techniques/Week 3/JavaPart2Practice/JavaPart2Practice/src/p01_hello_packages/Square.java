package p01_hello_packages;

/**
 * Simple class used to demonstrate importing from another package.
 */
public class Square {
    private final int side;

    public Square(int side) {
        this.side = side;
    }

    public int area() {
        return side * side;
    }

    public int perimeter() {
        return side * 4;
    }

    public void display() {
        System.out.println("Square(side=" + side + ", area=" + area() + ", perimeter=" + perimeter() +")");
    }
}
