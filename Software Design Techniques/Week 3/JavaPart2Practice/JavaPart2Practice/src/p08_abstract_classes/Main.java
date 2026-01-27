package p08_abstract_classes;

public class Main {
    public static void main(String[] args) {
        Shape a = new Square(3);
        Shape b = new Circle(2);

        a.display();
        b.display();

        Shape[] shapes = {a, b};
        Double totalArea = shapes[0].area() + shapes[1].area();
        System.out.println("Total Area: " + totalArea);
    }
}

