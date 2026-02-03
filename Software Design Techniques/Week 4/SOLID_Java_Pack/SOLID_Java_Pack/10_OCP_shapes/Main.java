public class Main {
    public static void main(String[] args) {
        System.out.println("== OCP (Open/Closed) ==");

        Shape[] shapes = new Shape[] {
                new Square(3),
                new Circle(2),
                new Triangle(3, 4)
        };

        AreaCalculator calc = new AreaCalculator();
        System.out.println("Total area = " + calc.totalArea(shapes));
    }
}
