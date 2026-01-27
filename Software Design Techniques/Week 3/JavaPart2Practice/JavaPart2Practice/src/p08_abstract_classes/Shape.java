package p08_abstract_classes;

public abstract class Shape {
    public abstract double area();

    public void display() {
        System.out.println(getClass().getSimpleName() + " area=" + area());
    }

    public abstract double perimeter();
}
