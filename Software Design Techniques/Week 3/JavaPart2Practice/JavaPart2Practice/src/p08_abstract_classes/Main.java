package p08_abstract_classes;

public class Main {
    public static void main(String[] args) {
        Shape a = new Square(3);
        Shape b = new Circle(2);

        a.display();
        b.display();

        // TODO: EXERCISE 2
        // Put both shapes into a Shape[] and compute total area.
    }
}

