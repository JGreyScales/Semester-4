package p08_abstract_classes;

public abstract class Shape {
    public abstract double area();

    public void display() {
        System.out.println(getClass().getSimpleName() + " area=" + area());
    }

    // TODO: EXERCISE 1
    // Add an abstract perimeter() method and implement it in subclasses.
}
